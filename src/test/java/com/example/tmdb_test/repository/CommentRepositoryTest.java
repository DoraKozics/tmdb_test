package com.example.tmdb_test.repository;

import com.example.tmdb_test.domain.Author;
import com.example.tmdb_test.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Rollback
@Transactional
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testSaveComment() {
        Comment comment = new Comment();
        comment.setText("Comment text");
        comment.setAuthor(new Author());
        comment.setDateCreated(LocalDateTime.now());
        comment.setMovie(1L);
        Comment commentSaved = commentRepository.save(comment);
        assertNotNull(commentSaved);
    }

    @Test
    void testFindCommentsByMovieId_Found() {
        Author author = new Author();
        authorRepository.save(author);
        Comment comment = new Comment();
        comment.setText("Comment text");
        comment.setAuthor(author);
        comment.setDateCreated(LocalDateTime.now());
        comment.setMovie(1L);
        commentRepository.save(comment);
        List<Comment> commentsForMovie = commentRepository.findAllCommentsByMovieId(1L);
        assertEquals(1, commentsForMovie.size());
    }

    @Test
    void testFindCommentsByMovieId_NoComments() {
        Author author = new Author();
        authorRepository.save(author);
        Comment comment = new Comment();
        comment.setText("Comment text");
        comment.setAuthor(author);
        comment.setDateCreated(LocalDateTime.now());
        comment.setMovie(1L);
        commentRepository.save(comment);

        List<Comment> allComments = commentRepository.findAll();
        List<Comment> commentsForMovie = commentRepository.findAllCommentsByMovieId(2L);

        boolean IsNotEmptyButMissing = !allComments.isEmpty() && commentsForMovie.isEmpty();
        assertTrue(IsNotEmptyButMissing);
    }
}