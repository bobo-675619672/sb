package com.ts.wb.util;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test3 {
	
	public static void main(String[] args) {
		DateTime start = DateTime.parse("2019-10-29");
		DateTime end = DateTime.now();
		
		Duration duration = new Duration(start, end);
		log.info("相差:{}", duration.getStandardDays());
	}
	
}
