package com.example.tmdb_test.service;

import com.example.tmdb_test.domain.Author;
import com.example.tmdb_test.domain.Comment;
import com.example.tmdb_test.dto.incoming.CommentCreationCommand;
import com.example.tmdb_test.repository.AuthorRepository;
import com.example.tmdb_test.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    private CommentService commentService;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private AuthorService authorService;

    @Mock
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        authorService = new AuthorService(authorRepository);
        commentService = new CommentService(commentRepository, authorService);
    }

//    @Test
//    void testCreateComment_WithNewAuthor() {
//        Author author = new Author();
//        author.setEmail("d@k.com");
//        author.setId(1L);
//        when(authorService.createAuthor("d@k.com")).thenReturn(author);
//
//        CommentCreationCommand command = new CommentCreationCommand();
//        command.setAuthorEmail("d@k.com");
//        command.setText("Comment Text");
//
//        Comment comment = commentService.createComment(command, 1L);
//
//        assertNotNull(comment);
//        assertEquals("d@k.com", comment.getAuthor().getEmail());
//    }
}