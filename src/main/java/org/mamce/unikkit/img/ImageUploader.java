package org.mamce.unikkit.img;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.mamce.unikkit.common.util.UnikkUtils;
import org.mamce.unikkit.exception.UnikkResourceException;

public class ImageUploader {

	public String uploadStudentAvatar(long studentId, String fileLocation) throws UnikkResourceException {
		File source = new File(fileLocation);
		File destination = null;
		String newPath = "";
		
		if(source != null && source.exists()) {
			newPath = UnikkUtils.getStudentImageUploadLocation(studentId, fileLocation);
			destination = new File(newPath);
			try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				throw new UnikkResourceException("Error while copying student avatar file", e);
			}
		} else {
			newPath = null;
		}
		
		return newPath;
	}
	
	public String uploadStaffAvatar(long staffId, String fileLocation) throws UnikkResourceException {
		File source = new File(fileLocation);
		File destination = null;
		String newPath = "";
		
		if(source != null && source.exists()) {
			newPath = UnikkUtils.getStaffImageUploadLocation(staffId, fileLocation);
			destination = new File(newPath);
			try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				throw new UnikkResourceException("Error while copying staff avatar file", e);
			}
		} else {
			newPath = null;
		}
		
		return newPath;
	}
	
}
