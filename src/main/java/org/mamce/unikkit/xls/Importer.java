package org.mamce.unikkit.xls;

import java.io.File;
import java.util.List;

import org.mamce.unikkit.exception.UnikkImporterException;
import org.mamce.unikkit.exception.UnikkResourceException;
import org.mamce.unikkit.model.BaseModel;
import org.primefaces.model.UploadedFile;

/**
 * @author IT09B007 - Ganesh
 *
 */
public interface Importer<T extends BaseModel> {

	/**
	 * @param xlsFile
	 * @return
	 * @throws UnikkImporterException
	 */
	List<T> importData(File xlsxFile) throws UnikkImporterException;
	
	/**
	 * @param filePath
	 * @return
	 * @throws UnikkImporterException
	 */
	List<T> importData(String filePath) throws UnikkImporterException;
	
	/**
	 * @param uploadedFile
	 * @return
	 * @throws UnikkResourceException
	 */
	public File createACopyInServer(UploadedFile uploadedFile) throws UnikkResourceException;
}
