package com.hz.study.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration

public class Swagger2Config {

    @Bean
    public Docket createDocket() {

        return new Docket(DocumentationType.SPRING_WEB)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title("JavaStudy-API文档")
                .description("")
                .termsOfServiceUrl("no term url")
                .version("1.0")
                .build();

    }

}
