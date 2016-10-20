package io.androidblog.retrofit2github.contributors;

import android.util.Log;

public class ContributorsInteractorImpl implements ContributorsInteractor {

    ContributorsRepository contributorsRepository;

    public ContributorsInteractorImpl(ContributorsTaskListener listener) {
        this.contributorsRepository = new ContributorsRepositoryImpl(listener);
    }

    @Override
    public void getContributors() {
        contributorsRepository.getContributors();
    }
}
