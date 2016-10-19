package io.androidblog.retrofit2github.models;

/**
 * Created by isabelpalomar on 10/19/16.
 */

public class Contributor {

    String login;
    String html_url;

    int contributions;

    @Override
    public String toString() {
        return login + " (" + contributions + ")";
    }
}