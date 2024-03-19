package com.example.tmdb_test.repository;

import com.example.tmdb_test.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@Rollback
@Transactional
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testFindAuthorByEmail_Existing() {
        Author author = new Author();
        author.setEmail("d@k.com");
        authorRepository.save(author);
        Author authorFound = authorRepository.findAuthorByEmail("d@k.com");
        assertNotNull(authorFound);
    }

    @Test
    void testFindAuthorByEmail_NotFound() {
        Author authorFound = authorRepository.findAuthorByEmail("d@k.com");
        assertNull(authorFound);
    }

}