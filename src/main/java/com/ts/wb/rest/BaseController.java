package com.ts.wb.rest;

import com.ts.wb.model.ResponseHead;
import com.ts.wb.model.ResponseMsg;

public class BaseController {

	public ResponseMsg<String> success(String msg) {
		ResponseMsg<String> responseMsg = new ResponseMsg<>();
		ResponseHead head = new ResponseHead("Success", "1", msg);
		responseMsg.setHead(head);
		return responseMsg;
	}
	
	public ResponseMsg<String> fail(String msg) {
		ResponseMsg<String> responseMsg = new ResponseMsg<>();
		ResponseHead head = new ResponseHead("Fail", "0", msg);
		responseMsg.setHead(head);
		return responseMsg;
	}
	
}
