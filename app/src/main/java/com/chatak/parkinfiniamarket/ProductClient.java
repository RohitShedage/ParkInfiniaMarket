package com.chatak.parkinfiniamarket;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ProductClient {
    private static final String API_BASE_URL = "http://ec2-54-165-229-42.compute-1.amazonaws.com:3000/";
    private AsyncHttpClient client;

    public ProductClient() {
        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    public void getProducts(final String query, JsonHttpResponseHandler handler) {
        try {
            String url = getApiUrl("api/cakes");
            URLEncoder.encode(query, "utf-8");
            client.get(url, handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}