package org.mamce.unikkit.web.bean;

import java.io.File;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.mamce.unikkit.exception.UnikkImporterException;
import org.mamce.unikkit.exception.UnikkResourceException;
import org.mamce.unikkit.model.staff.Staff;
import org.mamce.unikkit.staff.manager.StaffManager;
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
	
	@ManagedProperty(value=MP_STAFF_MANAGER)
	private StaffManager staffManager;
	
	/**
	 * @return the staffManager
	 */
	public StaffManager getStaffManager() {
		return staffManager;
	}


	/**
	 * @param staffManager the staffManager to set
	 */
	public void setStaffManager(StaffManager staffManager) {
		this.staffManager = staffManager;
	}


	public void handleStaffXlsUploadEvent(FileUploadEvent event) {  
		System.out.println("Upload started");
		UploadedFile uploadedFile = event.getFile();
		StaffImporter staffImporter = new StaffImporter();
		
		try {
			File xlsxFile = staffImporter.createACopyInServer(uploadedFile);
			List<Staff> staffs = staffImporter.importData(xlsxFile);
			
			if(staffs != null && !staffs.isEmpty()) {
				staffManager.saveAllStaff(staffs);
			}
			
		} catch (UnikkImporterException | UnikkResourceException e) {
			// TODO: RK: Implement logger
			e.printStackTrace();
		}
		
		FacesMessage msg = new FacesMessage("Staff Data Imported successfully!");
		FacesContext.getCurrentInstance().addMessage(null, msg); 
		System.out.println("Upload ended");
	}
	
}

