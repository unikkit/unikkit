package org.mamce.unikkit.xls;

public interface StaffImporterColumns {

	// Base Info Columns
	int STAFF_NUMBER = 0;
	int NAME = 1;
	int DOJ	= 2;
	int GENDER = 3;
	int DOB	= 4;
	int COLLEGE	= 5;
	int DESIGNATION = 6;
	int DEPARTMENT = 7;	
	int ADDRESS1 = 8;
	int ADDRESS2 = 9;
	int EMAIL = 10;
	int CITY = 11;
	int STATE = 12;
	int COUNTRY = 13;
	int AVATAR_PATH = 14;
	
	// Other Info Columns
	int OTHER_STAFF_NUMBER = 0;
	int OTHER_TYPE = 1;
	int OTHER_INT = 2;
	int OTHER_PUB_TYPE = 3;
	int OTHER_PUB_DESC = 4;
	int OTHER_PUB_YEAR = 5;
	int OTHER_ACHV_TYPE = 6;
	int OTHER_ACHV_DESC = 7;
	int OTHER_ACHV_YEAR = 8;
	int OTHER_MEM_TYPE = 9;
	int OTHER_MEM_DESC = 10;
	int OTHER_MEM_YEAR = 11;
	int OTHER_WRK_DESC = 12;
	int OTHER_WRK_START_YEAR = 13;
	int OTHER_WRK_END_YEAR = 14;
	
	String OTHER_DETAILS_TYPE_INTEREST = "INT";
	String OTHER_DETAILS_TYPE_PUB = "PUB";
	String OTHER_DETAILS_TYPE_ACHV = "ACHV";
	String OTHER_DETAILS_TYPE_MEM = "MEM";
	String OTHER_DETAILS_TYPE_WRK = "WRK";

	
	int SHEET_TYPE_BASE_INFO = 1;
	int SHEET_TYPE_OTHER_INFO = 2;
	
	String COL_NAME = "NAME";
	String COL_TYPE = "TYPE";
}
