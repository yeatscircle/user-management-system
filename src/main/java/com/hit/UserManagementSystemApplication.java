package com.hit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//开启了Servlet组件
@ServletComponentScan
@SpringBootApplication
public class UserManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementSystemApplication.class, args);
    }

}
