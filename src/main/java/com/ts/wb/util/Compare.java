package com.ts.wb.util;

public class Compare {

	public static void main(String[] args) {
		Integer a1 = 1;
		Integer b1 = 1;
		System.out.println(a1 == b1);
		
		Integer a2 = 120;
		Integer b2 = 120;
		System.out.println(a2.equals(b2));
		System.out.println(a2.intValue() == b2.intValue());

		
	}
}
