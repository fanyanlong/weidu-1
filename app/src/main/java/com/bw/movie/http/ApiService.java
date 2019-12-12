package com.bw.movie.http;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Describe：ApiService
 * Author：fan
 * Data：2019/11/7
 * Time:9:08
 */

public interface ApiService {
    public static final String BASE_URL = "http://172.17.8.100/";
    @Streaming
    @GET
    Observable<ResponseBody> executeDownload(@Header("Range") String range, @Url() String url);

}


