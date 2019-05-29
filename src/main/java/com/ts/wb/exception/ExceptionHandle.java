package com.ts.wb.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.wb.model.ResponseHead;
import com.ts.wb.model.ResponseMsg;

@ControllerAdvice
public class ExceptionHandle {

	 @ExceptionHandler(value = Exception.class)
	 @ResponseBody
	 public ResponseMsg<String> handle(Exception e) {
		 //判断异常是否是我们自定义的异常
		 if(e instanceof CoolException){
			 CoolException exception = (CoolException) e;
			 new ResponseMsg<String>(new ResponseHead("-1", String.valueOf(exception.getCode()), exception.getMessage()), "发生异常!");;
		 }
		 return new ResponseMsg<String>(new ResponseHead("-1", "-1", "发生异常!"), "发生异常!");
	 }
	 
}
