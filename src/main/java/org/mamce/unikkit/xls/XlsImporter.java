package org.mamce.unikkit.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.mamce.unikkit.exception.UnikkImporterException;
import org.mamce.unikkit.exception.UnikkResourceException;
import org.primefaces.model.UploadedFile;

/**
 * @author Ramesh
 *
 */
public class XlsImporter {

	public static final Logger LOGGER = Logger.getLogger(XlsImporter.class);
	
	/**
	 * @param fileName
	 * @return
	 * @throws UnikkImporterException
	 */
	protected List<Sheet> getAllXlsxSheets(String fileName) throws UnikkImporterException {
		List<Sheet> allSheets = null;
		try {
			allSheets = getAllSheets(new File(fileName));
		} catch (InvalidFormatException | IOException e) {
			throw new UnikkImporterException(e);
		}

		return allSheets;
	}

	/**
	 * @param xlsxFile
	 * @return
	 * @throws UnikkImporterException
	 */
	protected List<Sheet> getAllXlsxSheets(File xlsxFile) throws UnikkImporterException {
		List<Sheet> allSheets = null;
		try {
			allSheets = getAllSheets(xlsxFile);
		} catch (InvalidFormatException | IOException e) {
			throw new UnikkImporterException(e);
		}

		return allSheets;
	}

	protected String getStringValue(Cell cell) {
		String value = "";
		if(cell != null) {
			int type = cell.getCellType();
			switch (type) {
			case Cell.CELL_TYPE_BLANK:
				value = "";
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				value = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_ERROR:
				value = String.valueOf(cell.getErrorCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				
				break;
			case Cell.CELL_TYPE_NUMERIC:
				value = String.valueOf(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				value = String.valueOf(cell.getStringCellValue());
				break;
			default:
				break;
			}
		}
		
		return value;
	}

	protected int getIntValue(Cell cell) {
		int value = 0;
		if(cell != null) {
			int type = cell.getCellType();
			switch (type) {
			case Cell.CELL_TYPE_NUMERIC:
				value = Double.valueOf(cell.getNumericCellValue()).intValue();
				break;
			default:
				value = 0;
				break;
			}
		}
		
		return value;
	}
	
	protected Date getDateValue(Cell cell) {
		getStringValue(cell);
		return cell.getDateCellValue();
	}
	
	protected File createACopyInServer(UploadedFile uploadedFile, String destination) throws UnikkResourceException {
		FileOutputStream fos = null;
		File copy = null;
		
		if(uploadedFile == null) return null;
		
		LOGGER.info("Creating a copy in the server:"+uploadedFile.getFileName());
		LOGGER.info("Destination location:"+destination);
		try {
			copy = new File(destination);
			fos = new FileOutputStream(copy);
			fos.write(uploadedFile.getContents());
			fos.close();
			LOGGER.info("Successfully created a copy in the server!");
		} catch (IOException e) {
			throw new UnikkResourceException("Error while creating copy of the uploaded file", e);
		} finally {
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					throw new UnikkResourceException("Error while closing the stream when creating a copy of the uploaded file", e);
				}
			}
		}

		return copy;
	}
	
	/**
	 * @param xlsxFile
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	private List<Sheet> getAllSheets(File xlsxFile) throws InvalidFormatException, IOException {
		InputStream inputStream = new FileInputStream(xlsxFile);
		Workbook wb = WorkbookFactory.create(inputStream);
		List<Sheet> sheets = new ArrayList<>();
		for (int i = 0; i <wb.getNumberOfSheets(); i++) {
			sheets.add(wb.getSheetAt(i));
		}
		inputStream.close();
		return sheets;
	}
}
