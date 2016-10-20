package io.androidblog.retrofit2github.contributors.ui;

import java.util.List;

import io.androidblog.retrofit2github.models.Contributor;

public interface ContributorsView {
    void showProgressBar();
    void hideProgressBar();

    void showContributors(List<Contributor> contributors);
    void showErrorLoadingContributors(String error);

}