package com.simplelife.simplelife;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.simplelife.simplelife.mapper")
public class SimplelifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplelifeApplication.class, args);
    }

}
