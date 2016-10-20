package io.androidblog.retrofit2github.contributors;

import android.util.Log;

import java.util.List;

import io.androidblog.retrofit2github.contributors.ui.ContributorsView;
import io.androidblog.retrofit2github.models.Contributor;

public class ContributorsPresenterImpl implements ContributorsPresenter, ContributorsTaskListener {

    ContributorsView contributorsView;
    ContributorsInteractor contributorsInteractor;

    public ContributorsPresenterImpl(ContributorsView contributorsView) {
        this.contributorsView = contributorsView;
        this.contributorsInteractor = new ContributorsInteractorImpl(this);
    }

    @Override
    public void loadContributors() {
        contributorsInteractor.getContributors();
        contributorsView.showProgressBar();
    }

    @Override
    public void onContributorsLoaded(List<Contributor> contributors) {
        contributorsView.showContributors(contributors);
        contributorsView.hideProgressBar();
    }

    @Override
    public void onErrorLoadingContributors(String error) {
        contributorsView.showErrorLoadingContributors(error);
        contributorsView.hideProgressBar();
    }
}
