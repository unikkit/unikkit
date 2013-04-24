package org.mamce.unikkit.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class UnikkUtils {

	/**
	 * @return the today
	 */
	public static Date getToday() {
		return new Date();
	}

	public static String hashIt(String str) {
		String md5 = null;
        
        if(null == str) return null;
         
        try {
             
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
         
        //Update input string in message digest
        digest.update(str.getBytes(), 0, str.length());
 
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
           return null;
        }
        return md5;
	}
	
	public static String getStudentXlsUploadArcLocation(String originalFileName) {
		String studentArcLoc = PropertyUtils.getProperty("xls.upload.loc.student");
		String fileName = "ARC_Stud_" + getTimeStamp() + "." + getFileExtension(originalFileName);
		String fullQualifiedPath = MessageFormat.format(studentArcLoc, fileName);
		
		return fullQualifiedPath;
	}
	
	public static String getStaffXlsUploadArcLocation(String originalFileName) {
		String studentArcLoc = PropertyUtils.getProperty("xls.upload.loc.staff");
		String fileName = "ARC_Staff_" + getTimeStamp() + "." + getFileExtension(originalFileName);
		String fullQualifiedPath = MessageFormat.format(studentArcLoc, fileName);
		
		return fullQualifiedPath;
	}
	
	public static String getStudentImageUploadLocation(long studentId, String originalFileName) {
		String studentArcLoc = PropertyUtils.getProperty("img.upload.loc.student");
		String fileName = studentId + "." + getFileExtension(originalFileName);
		String fullQualifiedPath = MessageFormat.format(studentArcLoc, fileName);
		
		return fullQualifiedPath;
	}
	
	public static String getStaffImageUploadLocation(long staffId, String originalFileName) {
		String staffArcLoc = PropertyUtils.getProperty("img.upload.loc.staff");
		String fileName = staffId + "." + getFileExtension(originalFileName);
		String fullQualifiedPath = MessageFormat.format(staffArcLoc, fileName);
		
		
		return fullQualifiedPath;
	}
	
	public static String getTimeStamp() {
		return String.valueOf(new Date().getTime());
	}
	
	public static String getFileExtension(String fileName) {
		String ext = "";
		if(fileName != null) {
			int dotIndex = fileName.lastIndexOf(".");
			
			if(dotIndex > 0) {
				ext = fileName.substring(dotIndex + 1);
			}
		}
		
		return ext;
	}
	
	public static int getMaxLatestEventCount() {
		String maxCount = PropertyUtils.getProperty("max.dashboard.event.display");
		int max = 0;
		if(!"".equals(maxCount)) {
			max = Integer.valueOf(maxCount).intValue();
		} else {
			max = 50;
		}
		
		return max;
	}
	
	public static String getTimeFromDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.TIME_FORMAT);
		
		if(date == null) return "";
		
		return sdf.format(date);
	}
	
	public static String getReadableDateStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DT_FORMAT_DD_MMM_YYYY);
		
		if(date == null) return "";
		
		return sdf.format(date);
	}
	
	public static String generateRollNumber(int batch, int sequence) {
		sequence++;
		String rollNumberPattern = PropertyUtils.getProperty(Constants.PROP_KEY_ROLL_NUM_PATTERN);
		String yearTwoDigit = StringUtils.substring(String.valueOf(batch), 2);
		yearTwoDigit = StringUtils.leftPad(yearTwoDigit, 2, "0");
		String seq = StringUtils.leftPad(String.valueOf(sequence), 3, "0");
		
		return MessageFormat.format(rollNumberPattern, yearTwoDigit, seq);
	}
	
	public static String generateStaffNumber(String department, int sequence) {
		sequence++;
		String staffNumberPattern = PropertyUtils.getProperty(Constants.PROP_KEY_STAFF_NUM_PATTERN);
		String seq = StringUtils.leftPad(String.valueOf(sequence), 5, "0");
		
		return MessageFormat.format(staffNumberPattern, department, seq);
	}
	
}
