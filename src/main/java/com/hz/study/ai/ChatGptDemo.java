package com.hz.study.ai;

import cn.hutool.http.*;
import cn.hutool.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChatGptDemo {

    private static final String API_KEY = "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";

    public static void main(String[] args) {
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type","application/json;charset=UTF-8");

        JSONObject json = new JSONObject();
        //选择模型
        json.set("model","text-davinci-003");
        //添加我们需要输入的内容
        json.set("prompt","访问你一次大概花费多少人民币？");
        json.set("temperature",0.9);
        json.set("max_tokens",2048);
        json.set("top_p",1);
        json.set("frequency_penalty",0.0);
        json.set("presence_penalty",0.6);
        HttpResponse response = HttpRequest.post("https://api.openai.com/v1/completions")
                .setHttpProxy("127.0.0.1",33210)
                .headerMap(headers, false)
                .bearerAuth(API_KEY)
                .body(String.valueOf(json))
                .timeout(5 * 60 * 1000)
                .execute();

        System.out.println(response.body());
    }
}

