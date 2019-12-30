package com.thinking.file.transfer.station;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	@RequestMapping("")
	public String index() {
		return "/views/forms-file-upload.html";
	}

	@RequestMapping("/file/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		 if (file.isEmpty()) {
	            return "上传失败，请选择文件";
	        }

	        String fileName = file.getOriginalFilename();
	        try {
//	        	String path = ResourceUtils.getFile("classpath:template").getPath();
	        	// 项目在容器中实际发布运行的根路径
                String realPath = request.getSession().getServletContext().getRealPath("/");
	        	File dest = new File(realPath +"/files/"+ fileName);
	            file.transferTo(dest);
	            return "上传成功";
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	        return "上传失败！";
	}
}
