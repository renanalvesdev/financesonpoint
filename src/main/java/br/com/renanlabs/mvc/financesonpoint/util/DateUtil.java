package br.com.renanlabs.mvc.financesonpoint.util;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	//month and year
	public static final String MM_YYYY = "MM/yyyy";
	
	public static LocalDate stringToDate(String pattern, String date) {
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		YearMonth ym = YearMonth.parse(date, formatter);
		LocalDate dt = ym.atDay(1); // choose whatever day you want
		
		return dt;
	}
	
}
