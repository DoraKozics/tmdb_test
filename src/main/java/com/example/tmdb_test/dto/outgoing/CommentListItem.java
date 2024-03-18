package com.example.tmdb_test.dto.outgoing;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class CommentListItem {

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    private LocalDateTime dateCreated;

    private String text;

    public CommentListItem() {
    }

    public CommentListItem(LocalDateTime dateCreated, String text) {
        this.text = text;
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
