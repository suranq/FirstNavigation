package com.example.firstnavigation.utils;

import android.util.Log;

import java.io.File;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public class HttpUtils {

    public static RequestBody getBody(String json) {
        RequestBody requestBody = null;
        if (json != null) {
            requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded,charset-UTF-8"), json);
        }
        return requestBody;
    }

    public static RequestBody getUpLoadHeadImg(String userId, File file) {
        RequestBody requestBody = null;
        if (userId != null && file.getName() != null) {
            requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("userId", userId)
                    .addFormDataPart("headImageFile", file.getName(), RequestBody.create(MediaType.parse("image/jpg"), file))
                    .build();
        }
        return requestBody;
    }

    public static RequestBody getInfoTopic(String topicId, String userId) {
        FormBody body = null;
        if (topicId != null && userId != null) {
            body = new FormBody.Builder()
                    .add("topicId", topicId)
                    .add("userId", userId)
                    .build();
        }
        return body;
    }

    public static RequestBody getCollect(String userId, String cursor) {
        FormBody body = null;
        if (userId != null && cursor != null) {
            body = new FormBody.Builder()
                    .add("userId", userId)
                    .add("cursor", cursor)
                    .build();
        }
        return body;
    }

    public static RequestBody getHomePage(String userId, String lookUserId) {
        FormBody body = null;
        if (userId != null && lookUserId != null) {
            body = new FormBody.Builder()
                    .add("userId", userId)
                    .add("lookUserId", lookUserId)
                    .build();
        }
        return body;
    }

    public static RequestBody getCenter(String userId) {
        FormBody body = null;
        if (userId != null) {
            body = new FormBody.Builder()
                    .add("userId", userId)
                    .build();
        }
        return body;
    }

    public static RequestBody getBody2(String userId, String newsId) {
        FormBody body = null;
        if (userId != null && newsId != null) {
            body = new FormBody.Builder()
                    .add("userId", userId)
                    .add("newsId", newsId)
                    .build();
        }
        return body;
    }

    public static RequestBody getBodyRelevant(String newsId) {
        FormBody body = null;
        if (newsId != null) {
            body = new FormBody.Builder()
                    .add("newsId", newsId)
                    .build();
        }
        Log.e("body", body.toString());
        return body;
    }

    public static RequestBody getInserTpoic(String userId, String title, String tagList, List<String> fileList, String shareLink) {
        RequestBody requestBody = null;

        if (userId != null && tagList != null && title != null && shareLink != null) {
            requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("userId", userId)
                    .addFormDataPart("title", title)
                    .addFormDataPart("tagList", tagList)
                    .addFormDataPart("fileList", String.valueOf(fileList))
                    .addFormDataPart("shareLink", shareLink)
                    .build();
        }
        return requestBody;
    }

}
