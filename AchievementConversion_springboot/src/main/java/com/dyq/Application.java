package com.dyq;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 *文件上传配置 
	 *
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory fc = new MultipartConfigFactory();
		//单个文件最大
		fc.setMaxFileSize("20MB");
		//设置上传数据总大小
		fc.setMaxRequestSize("20MB");
		return fc.createMultipartConfig();
	}

}

