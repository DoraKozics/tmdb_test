package com.example.tmdb_test.service;

import com.example.tmdb_test.dto.outgoing.MovieDetails;
import com.example.tmdb_test.dto.outgoing.MovieListItem;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    private MovieService movieService;

    private String key = "58d4fb1a977f7dddeec36e364c4c1d6f";

    private String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1OGQ0ZmIxYTk3N2Y3ZGRkZWVjMzZlMzY0YzRjMWQ2ZiIsInN1YiI6IjY1ZjcxYjE2NTkwN2RlMDEzMGU1NDYyZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Y_qzDDZzE76nUpjW8yg7jHXJyy_mqKXAQm5_zCut9oE";

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        movieService = new MovieService(key, token, restTemplate);
    }

    @Test
    void testGetPopularMovies_collect_data() throws IOException, InterruptedException {
        List<MovieListItem> results = movieService.getPopularMovies();
        assertFalse(results.isEmpty());
    }

    @Test
    void testGetMovieDetails_Existing() throws IOException, InterruptedException {
        MovieDetails details = movieService.getMovieDetails(763215L);
        assertNotNull(details);
    }

    @Test
    void testGetMovieDetails_NonExisting() {
        assertThrows(JSONException.class, () -> movieService.getMovieDetails(0L));
    }
}