package com.example.tmdb_test.dto.outgoing;

public class MovieListItem {

    private Integer movieId;

    private String title;

    private String posterPath;

    private String releaseYear;

    public MovieListItem() {
    }

    public MovieListItem(Integer movieId, String title, String posterPath, String releaseYear) {
        this.movieId = movieId;
        this.title = title;
        this.posterPath = posterPath;
        this.releaseYear = releaseYear;
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
}
