package io.androidblog.retrofit2github.contributors;


import android.util.Log;
import android.widget.TextView;

import java.util.List;

import io.androidblog.retrofit2github.R;
import io.androidblog.retrofit2github.data.GitHubService;
import io.androidblog.retrofit2github.di.Injector;
import io.androidblog.retrofit2github.models.Contributor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContributorsRepositoryImpl implements ContributorsRepository {

    ContributorsTaskListener contributorsTaskListener;
    GitHubService gitHubService;


    public ContributorsRepositoryImpl(ContributorsTaskListener listener) {
        this.contributorsTaskListener = listener;
        this.gitHubService = Injector.provideGithubService();
    }

    @Override
    public void getContributors() {

        final Call<List<Contributor>> call =
                gitHubService.repoContributors("CodePathTeam8", "sightseeing-app");

        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {

                if (response.isSuccessful()){
                    contributorsTaskListener.onContributorsLoaded(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {
                contributorsTaskListener.onErrorLoadingContributors(t.getMessage());
            }
        });

    }
}
