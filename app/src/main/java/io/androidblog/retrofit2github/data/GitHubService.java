package io.androidblog.retrofit2github.data;

import java.util.List;

import io.androidblog.retrofit2github.models.Contributor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by isabelpalomar on 10/19/16.
 */

public interface GitHubService {

    @GET("repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

}