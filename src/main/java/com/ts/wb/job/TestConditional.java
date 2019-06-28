package com.ts.wb.job;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestConditional implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		log.info("不满足条件,不初始化");
		return false;
	}

}
