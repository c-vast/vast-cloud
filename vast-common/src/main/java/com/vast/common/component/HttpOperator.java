package com.vast.common.component;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * http通信服务
 */
@Slf4j
@Component
public class HttpOperator {

    public final static String APPLICATION_JSON = "application/json";

    private final OkHttpClient client = new OkHttpClient();

    private Request commonGetRequest(String url, Map<String, String> headerMap) throws Exception {
        Request.Builder builder = new Request.Builder();

        Request request;
        if (headerMap != null && headerMap.keySet().size() > 0) {
            Headers headers = Headers.of(headerMap);
            request = builder.get()
                    .url(url)
                    .headers(headers)
                    .build();
        } else {
            request = builder.get()
                    .url(url)
                    .build();
        }
        return request;
    }

    private Request.Builder commonPostBuilder(String url, Map<String, String> headerMap) throws Exception {
        Request.Builder builder;
        if (headerMap != null && headerMap.keySet().size() > 0) {
            Headers headers = Headers.of(headerMap);
            builder = new Request.Builder()
                    .url(url)
                    .headers(headers);
        } else {
            builder = new Request.Builder()
                    .url(url);
        }
        return builder;
    }

    public String get(String url, Map<String, String> headerMap) throws Exception {
        Request request = commonGetRequest(url, headerMap);

        Response response;
        try {
            response = client.newCall(request).execute();
            assert response.body() != null;
            return response.body().string();
        } catch (Exception e) {
            log.error("get请求发生异常", e.fillInStackTrace());
        }
        return null;
    }

    public String post(String url, Map<String, String> headerMap, String contentType, String data) throws Exception {
        Request.Builder builder = commonPostBuilder(url, headerMap);

        Request request;
        RequestBody requestBody;
        if (!Strings.isNullOrEmpty(data) && !Strings.isNullOrEmpty(contentType)) {
            requestBody = RequestBody.create(MediaType.parse(contentType), data);
            request = builder.post(requestBody).build();
        } else {
            FormBody.Builder bodyBuilder = new FormBody.Builder();
            request = builder.post(bodyBuilder.build()).build();
        }

        Response response;
        try {
            response = client.newCall(request).execute();
            assert response.body() != null;
            return response.body().string();
        } catch (IOException e) {
            log.error("post请求发生异常", e.fillInStackTrace());
        }
        return null;
    }


    public String post(String url) throws Exception {
        Request.Builder builder = new Request.Builder().url(url);
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        Request request = builder.post(bodyBuilder.build()).build();

        Response response;
        try {
            response = client.newCall(request).execute();
            assert response.body() != null;
            return response.body().string();
        } catch (IOException e) {
            log.error("post请求发生异常", e.fillInStackTrace());
        }
        return null;
    }

    public String post(String url, Map<String, String> headerMap, Map<String, String> bodyParams) throws Exception {
        Request.Builder builder = commonPostBuilder(url, headerMap);

        RequestBody body = setRequestBody(bodyParams);
        Request request = builder
                .post(body)
                .url(url)
                .build();

        Response response;
        try {
            response = client.newCall(request).execute();
            assert response.body() != null;
            return response.body().string();
        } catch (IOException e) {
            log.error("post请求发生异常", e.fillInStackTrace());
        }
        return null;
    }

    private RequestBody setRequestBody(Map<String, String> params) {
        RequestBody body;
        FormBody.Builder formBuilder = new FormBody.Builder();
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                formBuilder.add(key, params.get(key));
            }
        }
        body = formBuilder.build();

        return body;
    }

}



















