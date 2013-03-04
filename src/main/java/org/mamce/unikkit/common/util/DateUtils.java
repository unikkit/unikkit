package org.mamce.unikkit.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String DD_MM_YYYY = "dd/MM/yyyy";
	private final static SimpleDateFormat SDF_DD_MM_YYYY = new SimpleDateFormat(DD_MM_YYYY);
	
	public static Date parseDate(String date) throws ParseException {
		return SDF_DD_MM_YYYY.parse(date);
	}
}
