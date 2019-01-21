package com.ts.wb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		
		Long a = 128L;
		Long b = 128L;
		
		
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(a.longValue() == b.longValue());
		System.out.println(a.compareTo(b));
	}
	
}
