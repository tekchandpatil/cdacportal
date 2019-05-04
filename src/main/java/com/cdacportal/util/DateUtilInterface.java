package com.cdacportal.util;

import java.text.SimpleDateFormat;
import java.util.Date;



public interface DateUtilInterface {
	static String currentDate() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		Date currDate=new Date();
		return dateFormat.format(currDate);
	}
}
