package br.com.renanlabs.mvc.financesonpoint.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MonetaryUtil {

	public static Double formatTwoDecimalPlaces(Double value) {
		return new BigDecimal(value.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue();
	}
	
}
