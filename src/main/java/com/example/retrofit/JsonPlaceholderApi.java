package com.example.retrofit;

import com.example.retrofit.request.PostCreateRquest;
import com.example.retrofit.request.PostUpdateRequest;
import com.example.retrofit.response.PostsResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceholderApi {

    @GET("/posts")
    Call<List<PostsResponse>>posts(@Query("userId") Integer userId);

    @POST("/posts")
    Call<PostsResponse> create(@Body PostCreateRquest postCreateRquest);

    @PUT("/posts/{id}")
    Call<PostsResponse> update(@Path("id") Integer id, @Body PostUpdateRequest postUpdateRequest);

    @DELETE("/posts/{id}")
    Call<Void> delete(@Path("id") Integer id);
}
