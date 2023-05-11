package com.hz.study.ai.main;

import cn.hutool.http.*;
import cn.hutool.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChatGptImage {

    private static final String API_KEY = "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";


    public static void main(String[] args) {
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type","application/json;charset=UTF-8");
        JSONObject json = new JSONObject();
        //搜索关键字
        json.set("prompt","给我画一匹马，并且在马上插上翅膀，后面还有一辆飞机");
        //生成图片数
        json.set("n",2);
        //生成图片大小
        json.set("size","1024x1024");
        //返回格式
        json.set("response_format","url");
        //发送请求
        HttpResponse response = HttpRequest.post("https://api.openai.com/v1/images/generations")
                .setHttpProxy("127.0.0.1",33210)
                .headerMap(headers, false)
                .bearerAuth(API_KEY)
                .body(String.valueOf(json))
                .timeout(5 * 60 * 1000)
                .execute();
        System.out.println(response.body());
    }
}

