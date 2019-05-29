package com.ts.wb.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

	static int total = 707829217;
	
	public static void main(String[] args) {
		int a = 2;
		int b = 2;
		int comb = 0;
		A: for (; a < total; a = getNext(a)) {
			if (total % a != 0) {
				continue;
			}
			B: for (; b < total; b = getNext(b)) {
				comb = a * b;
				log.info("第1数 a:{}, 第2数 b:{}, 乘积:{}", a, b, comb);
				if (comb == total) { // 正确答案
					log.info("成功! a:{}, b:{}", a, b);
					break A;
				} else if (comb > total) {
					break B;
				}
			}
		}
	}
	
	private static int getNext(int a) {
		a += 1;
		for (; a < total; a++) {
			if (isPrime(a)) {
				return a;
			}
		}
		return total;
	}
	
	private static boolean isPrime(int a) {
		boolean isprime = true;
		int len = a / 2;
		for (int i = 2; i < len; i++) {
			if (a % i == 0) {
				isprime = false;
				break;
			}
		}
		return isprime;
	}
	
}
