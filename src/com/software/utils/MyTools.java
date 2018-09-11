package com.software.utils;

import java.io.UnsupportedEncodingException;



public class MyTools {

	public static boolean string_check(String userName,String pwd) {
		if (userName != null && !userName.equals("") && pwd != null && !pwd.equals("")) {
			return true;
		}
		return false;
	}

//	public static boolean register_deal(Users user, String pwd_sure) {
//		String userName = user.getUserName();
//		String pwd = user.getPwd();
//
//		if (userName != null && !userName.equals("") && pwd != null
//				&& !pwd.equals("") && pwd.equals(pwd_sure)) {
//			return true;
//		}
//		return false;
//	}

	public static int strToint(String str) {
		if (str == null || str.equals("")) {
			str = "";
		}
		int i = 0;
		try {
			i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			i = 0;
			e.printStackTrace();
		}
		return i;
	}

	public static String toChinese(String str) {
		if (str == null || str.equals("")) {
			str = "";
		}
		try {
			str = new String((str.getBytes("iso-8859-1")), "utf-8");
		} catch (UnsupportedEncodingException e) {
			str = "";
			e.printStackTrace();
		}
		return str;
	}
}
