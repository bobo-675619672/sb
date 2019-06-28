package com.ts.wb.util;

public class Test111 {
	
	public static void main(String[] args) {
		double per = 50000.0;
		int year = 10;
		double sum = 0.0;
		double rate = 0.05;
		
		for (int i = 1; i <= year; i++) {
			sum += per;
			System.out.println("第" + i + "年, 单价:" + per + ",总数:" + sum);
			per = per * (1 + rate);
		}
	}
	
}
