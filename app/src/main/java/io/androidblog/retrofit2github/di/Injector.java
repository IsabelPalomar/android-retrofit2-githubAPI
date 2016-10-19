package io.androidblog.retrofit2github.di;

import io.androidblog.retrofit2github.data.GitHubService;
import io.androidblog.retrofit2github.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injector {

    public static Retrofit provideRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static GitHubService provideGithubService(){
        return provideRetrofit(Constants.GITHUB_SERVICE_BASE_URL).create(GitHubService.class);
    }
}
