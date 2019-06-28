package com.ts.wb.job;

import java.util.Map;

import org.joda.time.LocalDateTime;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import com.google.common.collect.Maps;

//@Configuration
//@EnableScheduling
public class JobConfig implements SchedulingConfigurer {

	static Map<String, String> cronMap = Maps.newHashMap();
	
	static {
		cronMap.put("key", "com.ts.wb.job.showTime");
		cronMap.put("cron", "0/5 * * * * *");
		
	}
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask(
				// 1.添加任务内容(Runnable)
				() -> {
					// 1.1具体任务
					System.out.println("执行定时任务: " + LocalDateTime.now().toLocalTime());
				},
				// 2.设置执行周期(Trigger)
				triggerContext -> {
					return new CronTrigger(cronMap.get("cron")).nextExecutionTime(triggerContext);
				});
	}

}
