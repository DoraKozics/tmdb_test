package com.example.tmdb_test.controller;

import com.example.tmdb_test.dto.outgoing.MovieDetails;
import com.example.tmdb_test.dto.outgoing.MovieListItem;
import com.example.tmdb_test.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/popular")
    public ResponseEntity<List<MovieListItem>> getPopularMovies() {
        try {
            List<MovieListItem> popularData = movieService.getPopularMovies();
            return new ResponseEntity<>(popularData, HttpStatus.OK);

        } catch (IOException | InterruptedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetails> getMovieDetailsById(@PathVariable("id") Long id) {
        try {
            MovieDetails details = movieService.getMovieDetails(id);
            return new ResponseEntity<>(details, HttpStatus.OK);
        } catch (IOException | InterruptedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
