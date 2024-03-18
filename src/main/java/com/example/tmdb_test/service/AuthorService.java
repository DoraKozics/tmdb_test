package com.example.tmdb_test.service;

import com.example.tmdb_test.domain.Author;
import com.example.tmdb_test.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(String email) {
        Author author = new Author();
        author.setEmail(email);
        return authorRepository.save(author);
    }

    public Author findAuthorByEmail(String email) {
        return authorRepository.findAuthorByEmail(email);
    }
}
