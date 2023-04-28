package com.hz.study.ai;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class OpenAIApiExample {

    private static final String API_KEY = "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";
    private static final String API_URL = "https://api.openai.com/v1/engines/davinci-codex/completions";

    public static void main(String[] args) {
        try {
            // 构造 API 请求的参数
            String prompt = "请问访问你一次大概花费多少人民币";
            String model = "davinci-codex";
            int maxTokens = 2048;
            String requestBody = buildRequestBody(prompt, model, maxTokens);
            
            // 创建 HTTP POST 请求
            HttpPost request = new HttpPost(API_URL);
            request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + API_KEY);
            request.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            request.setEntity(new StringEntity(requestBody, StandardCharsets.UTF_8));

            // 发送 HTTP 请求并获取响应
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            
            // 解析响应的 JSON 数据
            JSONObject jsonResponse = new JSONObject(responseString);
            String outputText = jsonResponse.getJSONArray("choices").getJSONObject(0).getString("text");
            System.out.println(outputText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static String buildRequestBody(String prompt, String model, int maxTokens) 
            throws Exception {
        JSONObject requestBodyJson = new JSONObject();
        requestBodyJson.put("prompt", prompt);
        requestBodyJson.put("model", model);
        requestBodyJson.put("max_tokens", maxTokens);
        requestBodyJson.put("temperature", 0.5);
        requestBodyJson.put("n", 1);
        requestBodyJson.put("stop", "\n");
        String requestBody = requestBodyJson.toString();
        requestBody = URLEncoder.encode(requestBody, StandardCharsets.UTF_8.name());
        return "parameters=" + requestBody;
    }

}
