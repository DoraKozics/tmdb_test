package com.example.tmdb_test.dto.incoming;

import jakarta.validation.constraints.Email;

public class CommentCreationCommand {

    private String text;

    @Email
    private String authorEmail;

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
}
