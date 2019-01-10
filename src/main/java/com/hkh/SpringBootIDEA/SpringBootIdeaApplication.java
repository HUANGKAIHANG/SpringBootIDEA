package com.hkh.SpringBootIDEA;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.hkh.SpringBootIDEA.mapper")
public class SpringBootIdeaApplication extends SpringBootServletInitializer {
    @Override //启动类对Servlet的支持（需要打包构建war及部署在服务器上时）
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootIdeaApplication.class);
    }

    //主程序，运行后使用默认容器部署
    public static void main(String[] args) {
        SpringApplication.run(SpringBootIdeaApplication.class, args);
    }

}

