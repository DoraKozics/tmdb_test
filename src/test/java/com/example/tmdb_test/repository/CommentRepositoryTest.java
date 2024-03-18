package com.example.tmdb_test.repository;

import com.example.tmdb_test.domain.Author;
import com.example.tmdb_test.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Rollback
@Transactional
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

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
}