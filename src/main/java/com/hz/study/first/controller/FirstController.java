package com.hz.study.first.controller;

import com.hz.study.first.service.FirstService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
@Api(description = "第一次访问")
public class FirstController {

    @Autowired
    private FirstService firstService;

    @GetMapping("/one")
    @ApiOperation("第一个访问接口")
    public Object getUserList(@RequestParam String param){
        System.out.println(param);
        return firstService.firstMethod();
    }

    
}
