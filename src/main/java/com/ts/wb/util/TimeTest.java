package com.ts.wb.util;

public class TimeTest {

	public static Double getS(Double time) {
		return (time * 6.0) % 60;
	}
	
	public static Double getM(Double time) {
		return (time / 10.0) % (60 * 60);
	}
	
	public static Double getH(Double time) {
		return (time / 120.0) % (60 * 60 * 12);
	}
	
	public static void main(String[] args) {
//		System.out.println(getS(0.0).doubleValue() == getM(0.0).doubleValue());
//		System.out.println(getM(0.0) == getH(0.0));
		for (Double time = 0.0; time <= 60 * 60 * 24.0; time += 0.01) {
			if (getS(time).doubleValue() == getM(time).doubleValue()
					&& getM(time).doubleValue() == getH(time).doubleValue()) {
				System.out.println(time);
			}
		}
	}
	
}
