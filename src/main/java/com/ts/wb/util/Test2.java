package com.ts.wb.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test2 {

	static int total = 866278171;
	
	
	public static void main(String[] args) {
		
		Runnable run1 = new MyRun(1, 99);
		run1.run();
	}
	
	
	
	
	
}

@Slf4j
class MyRun implements Runnable {

	String flag = "3";
	
	int start;
	int end;
	
	public MyRun() {
		
	}
	
	public MyRun(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		
		int sum = 0;
		for (int a = start; a < end; a += 2) {
			sum += get3Num(a);
		}
		log.info("start:{}, end: {}, 次数: {}", start, end, sum);
	} 
	
	private int get3Num(int a) {
		String aStr = String.valueOf(a);
		int index = 0;
		int count = 0;
		while ((index = aStr.indexOf(flag, index)) != -1) {
			count++;
			index = index + flag.length();
		}
		return count;
	}
	
}