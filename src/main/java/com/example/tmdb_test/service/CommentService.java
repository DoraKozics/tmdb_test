package com.example.tmdb_test.service;

import com.example.tmdb_test.domain.Author;
import com.example.tmdb_test.domain.Comment;
import com.example.tmdb_test.dto.incoming.CommentCreationCommand;
import com.example.tmdb_test.dto.outgoing.CommentListItem;
import com.example.tmdb_test.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public Comment createComment(CommentCreationCommand command) {
        Author author = authorService.findAuthorByEmail(command.getAuthorEmail());

        if (author == null) {
            author = authorService.createAuthor(command.getAuthorEmail());
        }

        Comment comment = new Comment();
        comment.setAuthor(author);
        comment.setMovie(command.getMovieId());
        comment.setText(command.getText());
        comment.setDateCreated(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public List<CommentListItem> getAllCommentsByMovieId(Long id) {
        List<Comment> comments = commentRepository.findAllCommentsByMovieId(id);
        return comments.stream()
                .map(comment -> new CommentListItem(comment.getDateCreated(), comment.getText()))
                .collect(Collectors.toList());
    }
}
