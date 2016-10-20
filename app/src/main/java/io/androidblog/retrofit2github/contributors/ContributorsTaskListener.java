package io.androidblog.retrofit2github.contributors;

import java.util.List;

import io.androidblog.retrofit2github.models.Contributor;

public interface ContributorsTaskListener {
    void onContributorsLoaded(List<Contributor> contributors);
    void onErrorLoadingContributors(String error);
}
