package com.example.tmdb_test.controller;

import com.example.tmdb_test.domain.Comment;
import com.example.tmdb_test.dto.incoming.CommentCreationCommand;
import com.example.tmdb_test.dto.outgoing.CommentListItem;
import com.example.tmdb_test.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody CommentCreationCommand command) {
        Comment commentCreated = commentService.createComment(command);

        if (commentCreated != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CommentListItem>> getAllCommentsByMovieId(@PathVariable("id") Long id) {
        List<CommentListItem> comments = commentService.getAllCommentsByMovieId(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
