package com.ts.wb.job;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.joda.time.DateTime;
import org.mapstruct.BeforeMapping;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ts.wb.annotation.Check;

import lombok.extern.slf4j.Slf4j;

@Service
@EnableScheduling
@Slf4j
//@Check
public class RunJob {

//	@Check
	@Scheduled(fixedRate = 60000)
	public void showTime() {
		log.info("每 {} 秒执行, 当前时间: {}", 60, DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
	}
	
//	@Scheduled(fixedRate = 2000)
//	public void showTime2() {
//		check();
//		log.info("每 {} 秒执行, 当前时间: {}", 2, DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
//	}
//	
//	@Scheduled(cron = "0 0/1 * * * *")
//	public void showTime3() {
//		check();
//		log.info("每 {} 秒执行, 当前时间: {}", 60, DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
//	}
	
	
	private void check() {
		log.info("检查!");
	}
	
}
