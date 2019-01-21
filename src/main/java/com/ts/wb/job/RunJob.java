package com.ts.wb.job;

import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RunJob {

	@Scheduled(fixedRate = 5000)
	public void showTime() {
		log.info("每 {} 秒执行, 当前时间: {}", 5, DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
	}
	
	@Scheduled(cron = "0 0/1 * * * *")
	public void showTime2() {
		log.info("每 {} 秒执行, 当前时间: {}", 60, DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
	}
	
}
