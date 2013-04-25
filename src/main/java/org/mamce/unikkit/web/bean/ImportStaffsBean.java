package org.mamce.unikkit.web.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.mamce.unikkit.common.util.FacesUtils;
import org.mamce.unikkit.exception.UnikkImporterException;
import org.mamce.unikkit.exception.UnikkResourceException;
import org.mamce.unikkit.img.ImageUploader;
import org.mamce.unikkit.model.staff.Staff;
import org.mamce.unikkit.staff.manager.StaffManager;
import org.mamce.unikkit.xls.StaffImporter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 * @author IT09B007 - Ganesh
 *
 */
@ManagedBean
@RequestScoped
public class ImportStaffsBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger LOGGER = Logger.getLogger(ImportStaffsBean.class);
	
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
		StaffImporter staffImporter = new StaffImporter(staffManager);

		try {
			File xlsxFile = staffImporter.createACopyInServer(uploadedFile);
			List<Staff> staffs = staffImporter.importData(xlsxFile);

			if(staffs != null && !staffs.isEmpty()) {
				staffManager.saveAllStaff(staffs);
			}

			ImageUploader imgUploader = new ImageUploader();
			List<Staff> updateStaffs = new ArrayList<>();
			
			// Upload student avatar
			for (Staff staff : staffs) {
				if(staff != null && staff.getAvatar() != null) {
					String uploadedPath = imgUploader.uploadStaffAvatar(staff.getId(), staff.getAvatar());
					staff.setAvatar(uploadedPath);
					updateStaffs.add(staff);
				}
			}
			staffManager.saveAllStaff(updateStaffs);
		} catch (UnikkImporterException | UnikkResourceException e) {
			LOGGER.error("Error while importing staff informations", e);
		}

		FacesUtils.addInfoMessage("Staff Data Imported successfully!");
	}
	
}

