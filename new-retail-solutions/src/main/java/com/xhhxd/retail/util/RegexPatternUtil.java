package com.xhhxd.retail.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexPatternUtil {
	
	public static boolean isMobile(String value) {
		String regex = "^((13|14|15|17|18)[0-9]{9})$";
		return match(regex, value);
	}

	public static boolean isExcel(String value) {
		String regex = "^(\\.xl(s|sx))$";
		return match(regex, value);
	}
	
	public static boolean isEmail(String value) {
		String regex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		return match(regex, value);
	}

	public static boolean isMobileOrPhone(String value) {
		String regex = "(^(\\d{2,4}-)?\\d{7,8})$|((13|15|17|18|14)[0-9]{9})$";
		return match(regex, value);
	}

	public static boolean isUserName(String value) {
		String regex = "^[a-zA-Z][a-zA-Z0-9_-]{3,}$";
		return match(regex, value);
	}

	public static boolean isUserName(String value, int minLength) {
		String regex = "^[a-zA-Z][a-zA-Z0-9_-]{" + minLength + ",}$";
		return match(regex, value);
	}

	public static boolean isUserName(String value, int minLength, int maxLength) {
		String regex = "^[a-zA-Z][a-zA-Z0-9_-]{" + minLength + "," + maxLength + "}$";
		return match(regex, value);
	}

	public static boolean isIP(String value) {
		String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
		String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
		return match(regex, value);
	}

	public static boolean IsTelephone(String value) {
		String regex = "(^(\\d{2,4}-)?\\d{7,8})$";
		return match(regex, value);
	}

	public static boolean IsIDcard(String value) {
		String regex = "(^\\d{18}$)|(^\\d{15}$)";
		return match(regex, value);
	}

	public static boolean isUrl(String value) {
		String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
		return match(regex, value);
	}

	public static boolean isDecimal(String value) {
		String regex = "^[0-9]+(.[0-9]{2})?$";
		return match(regex, value);
	}

	public static boolean isMonth(String value) {
		String regex = "^(0?[[1-9]|1[0-2])$";
		return match(regex, value);
	}

	public static boolean isDate(String value) {
		// 严格验证时间格式的(匹配[2002-01-31], [1997-04-30],
		// [2004-01-01])不匹配([2002-01-32], [2003-02-29], [04-01-01])
		// String regex =
		// "^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((01,3-9])|(1[0-2]))-(29|30)))))$";
		// 没加时间验证的YYYY-MM-DD
		// String regex =
		// "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$";
		// 加了时间验证的YYYY-MM-DD 00:00:00
		String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
		return match(regex, value);
	}

	public static boolean isNumber(String value) {
		String regex = "^[0-9]*$";
		return match(regex, value);
	}

	public static boolean isIntNumber(String value) {
		String regex = "^\\+?[1-9][0-9]*$";
		return match(regex, value);
	}

	public static boolean isUpChar(String value) {
		String regex = "^[A-Z]+$";
		return match(regex, value);
	}

	public static boolean isLowChar(String value) {
		String regex = "^[a-z]+$";
		return match(regex, value);
	}

	public static boolean isChinese(String value) {
		String regex = "^[\u4e00-\u9fa5],{0,}$";
		return match(regex, value);
	}

	public static boolean match(String regex, String value) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
}