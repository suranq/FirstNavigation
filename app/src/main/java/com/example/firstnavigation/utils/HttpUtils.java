package com.example.firstnavigation.utils;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public class HttpUtils {

    public static RequestBody getBody(String json){
        RequestBody requestBody = null;
        if (json != null){
            requestBody = RequestBody.create(MediaType.parse("Content-Type:application/x-www-form-urlencoded,charset-UTF-8"),json);
        }
        return requestBody;
    }
}
