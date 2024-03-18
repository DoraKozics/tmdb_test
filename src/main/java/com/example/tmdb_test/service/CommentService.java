package com.example.tmdb_test.service;

import com.example.tmdb_test.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    private final AuthorService authorService;

    @Autowired
    public CommentService(CommentRepository commentRepository, AuthorService authorService) {
        this.commentRepository = commentRepository;
        this.authorService = authorService;
    }
}
