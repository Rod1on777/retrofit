package com.example.retrofit;

import com.example.retrofit.request.PostCreateRquest;
import com.example.retrofit.request.PostUpdateRequest;
import com.example.retrofit.response.PostsResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] arg) throws IOException {
        System.out.println("hello");

        JsonPlaceholderApi api = JsonPlaceholderService.getInstance().api();

        System.out.println("GET:/posts ----------------");
        Response<List<PostsResponse>> postsResponses = api.posts(null).execute();
        System.out.println(postsResponses.code());
        System.out.println(postsResponses.headers());
        List<PostsResponse> posts = postsResponses.body();
        System.out.println(posts);

        System.out.println("CREATE:/posts ----------------");
        PostCreateRquest createRequest = new PostCreateRquest();
        createRequest.setBody("create");
        createRequest.setTitle("creaded");
        createRequest.setUserId(1);
        PostsResponse postsResponseCreate = api.create(createRequest).execute().body();
        System.out.println(postsResponseCreate);

        System.out.println("PUT:/posts ----------------");
        PostUpdateRequest putRequest = new PostUpdateRequest();
        putRequest.setBody("put something");
        putRequest.setUserId(2);
        putRequest.setId(2);
        PostsResponse postsResponsePut = api.update(1, putRequest).execute().body();
        System.out.println(postsResponsePut);

        System.out.println("DELETE:/posts ----------------");
        Integer code = api.delete(1).execute().code();
        System.out.println(code);



    }
}
