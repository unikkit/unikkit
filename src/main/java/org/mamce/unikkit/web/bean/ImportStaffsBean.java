package org.mamce.unikkit.web.bean;

import java.io.File;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.mamce.unikkit.exception.UnikkImporterException;
import org.mamce.unikkit.exception.UnikkResourceException;
import org.mamce.unikkit.model.staff.Staff;
import org.mamce.unikkit.xls.StaffImporter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 * @author Ramesh
 *
 */
@ManagedBean
@RequestScoped
public class ImportStaffsBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void handleStaffXlsUploadEvent(FileUploadEvent event) {  
		System.out.println("Upload started");
		UploadedFile uploadedFile = event.getFile();
		StaffImporter staffImporter = new StaffImporter();
		
		try {
			File xlsxFile = staffImporter.createACopyInServer(uploadedFile);
			List<Staff> staffs = staffImporter.importData(xlsxFile);
			// TODO: RK: Import the staffs in to the database
			
			if(staffs != null && !staffs.isEmpty()) {
				for (Staff staff : staffs) {
					System.out.println(staff.getStaffId());
				}
			}
			System.out.println();
		} catch (UnikkImporterException | UnikkResourceException e) {
			// TODO: RK: Implement logger
			e.printStackTrace();
		}
		
		FacesMessage msg = new FacesMessage("Staff Data Imported successfully!");
		FacesContext.getCurrentInstance().addMessage(null, msg); 
		System.out.println("Upload ended");
	}

	
}

