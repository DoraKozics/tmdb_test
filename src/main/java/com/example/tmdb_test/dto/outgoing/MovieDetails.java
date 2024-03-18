package com.example.tmdb_test.dto.outgoing;

import java.util.ArrayList;
import java.util.List;

public class MovieDetails {

    private Long id;

    private String title;

    private String language;

    private String overview;

    private String posterPath;

    private String releaseYear;

    private double voteAverage;

    private int voteCount;

    public MovieDetails() {
    }

    public MovieDetails(Long id, String title, String language, String overview, String posterPath, String releaseYear, double voteAverage, int voteCount) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.overview = overview;
        this.posterPath = posterPath;
        this.releaseYear = releaseYear;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
