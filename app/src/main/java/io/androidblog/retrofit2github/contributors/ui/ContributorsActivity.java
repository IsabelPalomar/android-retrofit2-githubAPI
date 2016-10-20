package io.androidblog.retrofit2github.contributors.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import io.androidblog.retrofit2github.R;
import io.androidblog.retrofit2github.contributors.ContributorsPresenter;
import io.androidblog.retrofit2github.contributors.ContributorsPresenterImpl;
import io.androidblog.retrofit2github.data.GitHubService;
import io.androidblog.retrofit2github.di.Injector;
import io.androidblog.retrofit2github.models.Contributor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContributorsActivity extends AppCompatActivity implements ContributorsView {

    ContributorsPresenterImpl contributorsPresenter;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.textView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        contributorsPresenter = new ContributorsPresenterImpl(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contributorsPresenter.loadContributors();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showContributors(List<Contributor> contributors) {
        textView.setText(contributors.toString());
    }

    @Override
    public void showErrorLoadingContributors(String error) {
        textView.setText(error);
    }
}
