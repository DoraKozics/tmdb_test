package com.example.tmdb_test.dto.outgoing;

public class MovieListItem {

    private Integer movieId;

    private String title;

    private String posterPath;

//    genres;

    private String releaseYear;

    private double voteAverage;

    private int voteCount;

    private String overview;

    public MovieListItem() {
    }

    public MovieListItem(Integer movieId, String title, String posterPath, String releaseYear, double voteAverage, int voteCount, String overview) {
        this.movieId = movieId;
        this.title = title;
        this.posterPath = posterPath;
        this.releaseYear = releaseYear;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.overview = overview;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
