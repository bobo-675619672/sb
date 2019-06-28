package com.ts.wb.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ts.wb.annotation.Food;
import com.ts.wb.model.ResponseMsg;
import com.ts.wb.service.ShowService;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

	@Food
	private String name;
	
	@Profile("dev")
	private String devBean() {
		return "dev";
	}
	
	@Profile("prod")
	private String prodBean() {
		return "prod";
	}
	
	@Autowired
	private ShowService showService;
	
	@GetMapping("/error")
	public ResponseMsg<String> error() {
		int i = 1 / 0;
		return fail("发生错误啦!!!");
	}
	
	@GetMapping("/show")
	public String show() {
		return showService.show();
	}
	
	@GetMapping("/download/{fileName}")
	public void download(@PathVariable String fileName, HttpServletResponse response) {
		try {
		 	Resource resource = new ClassPathResource("templates/" + fileName);
    		File file = resource.getFile();
    		String filename = resource.getFilename();
    		InputStream inputStream = new FileInputStream(file);
            //强制下载不打开
    		response.setContentType("application/force-download");
            OutputStream out = response.getOutputStream();
            //使用URLEncoder来防止文件名乱码或者读取错误
            response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename, "UTF-8"));
            int b = 0;
            byte[] buffer = new byte[1000000];
            while (b != -1) {
                b = inputStream.read(buffer);
                if(b!=-1) out.write(buffer, 0, b);
            }
            inputStream.close();
            out.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
}
