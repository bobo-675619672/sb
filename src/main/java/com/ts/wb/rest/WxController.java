package com.ts.wb.rest;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/wx")
@Slf4j
public class WxController extends BaseController {
	
	private final String token = "liaodw";
	private final String appID = "wx21e2b71409272168";
	private final String appsecret = "59965645a4f87c34f8bb6c21f0999fa0";
	
	@GetMapping("/{type}")
	private String show(@PathVariable String type) throws ServletException, IOException {
		
		return "听德云社的都是大傻逼!";
	}
	
	@GetMapping()
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("Start!Params: {}", JSONObject.toJSONString(request.getParameterMap()));
		String signature = request.getParameter("signature");
	    String timestamp = request.getParameter("timestamp");
	    String nonce = request.getParameter("nonce");
	    String echostr = request.getParameter("echostr");
	 
	    ArrayList<String> array = new ArrayList<String>();
	    array.add(signature);
	    array.add(timestamp);
	    array.add(nonce);
	 
	    //排序
	    String sortString = sort(token, timestamp, nonce);
	    //加密
	    String mytoken = SHA1(sortString);
	    //校验签名
	    if (mytoken != null && mytoken != "" && mytoken.equals(signature)) {
	        log.info("签名校验通过。");
	        response.getWriter().println(echostr); //如果检验成功输出echostr，微信服务器接收到此输出，才会确认检验完成。
	    } else {
	        log.info("签名校验失败。");
	    }
	}
	
	
	
	/**
	 * 排序方法
	 * @param token
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static String sort(String token, String timestamp, String nonce) {
	    String[] strArray = { token, timestamp, nonce };
	    Arrays.sort(strArray);
	 
	    StringBuilder sbuilder = new StringBuilder();
	    for (String str : strArray) {
	        sbuilder.append(str);
	    }
	 
	    return sbuilder.toString();
	}
	
	public static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
	
}
