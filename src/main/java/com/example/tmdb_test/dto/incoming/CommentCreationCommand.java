package com.example.tmdb_test.dto.incoming;

import jakarta.validation.constraints.Email;

public class CommentCreationCommand {

    private String text;

    @Email
    private String authorEmail;

    private Long movieId;

    public CommentCreationCommand() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
