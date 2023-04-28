package com.hz.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.hz.study.*.dao")
@ServletComponentScan
public class JavaStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaStudyApplication.class, args);
    }

}
