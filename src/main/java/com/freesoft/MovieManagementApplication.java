package com.freesoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhouwei
 */
@SpringBootApplication
@MapperScan("com.freesoft.mapper")
public class MovieManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieManagementApplication.class, args);
    }
}
