package com.example.tmdb_test.service;

import com.example.tmdb_test.dto.outgoing.MovieDetails;
import com.example.tmdb_test.dto.outgoing.MovieListItem;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MovieService {

    private String key;

    private String token;

    private final RestTemplate restTemplate;

    public MovieService(@Value("${tmdbApiKey}") String key,
                        @Value("${tmdbApiToken}") String token,
                        RestTemplate restTemplate) {
        this.key = key;
        this.token = token;
        this.restTemplate = restTemplate;
    }

    public List<MovieListItem> getPopularMovies() throws IOException, InterruptedException {
        List<MovieListItem> popularMovies = new ArrayList<>();
        int currentPage = 1;
        int totalPages = 2;

        while (currentPage <= totalPages) {
            String url = "https://api.themoviedb.org/3/movie/popular?language=en-US" + "&page=" + currentPage;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("accept", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            popularMovies.addAll(mapPopularMoviesToDTO(response.body()));
            currentPage++;
        }
        return popularMovies;
    }

    private List<MovieListItem> mapPopularMoviesToDTO(String response) {
        JSONObject jsonObject = new JSONObject(response);
        JSONArray resultsArray = jsonObject.getJSONArray("results");
        List<MovieListItem> popularMovies = new ArrayList<>();

        for (int i = 0; i < resultsArray.length(); i++) {
            JSONObject movieObject = resultsArray.getJSONObject(i);

            Integer movieId = movieObject.getInt("id");
            String title = movieObject.getString("title");
            String posterPath = movieObject.getString("poster_path");
            String releaseYear = getReleaseYear(movieObject.getString("release_date"));

            popularMovies.add(new MovieListItem(movieId, title, posterPath, releaseYear));
        }
        return popularMovies;
    }

    public MovieDetails getMovieDetails(Long id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + key))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return mapMovieDetailsToDTO(response.body());
    }

    private MovieDetails mapMovieDetailsToDTO(String response) {
        JSONObject movieObject = new JSONObject(response);
        MovieDetails movieDetails = new MovieDetails();

        movieDetails.setId((long) movieObject.getInt("id"));
        movieDetails.setTitle(movieObject.getString("title"));
        movieDetails.setLanguage(movieObject.getString("original_language"));
        movieDetails.setOverview(movieObject.getString("overview"));
        movieDetails.setPosterPath(movieObject.getString("poster_path"));
        movieDetails.setReleaseYear(movieObject.getString("release_date").substring(0, 4));
        movieDetails.setVoteAverage(movieObject.getInt("vote_average"));
        movieDetails.setVoteCount(movieObject.getInt("vote_count"));

        return movieDetails;
    }

    private String getReleaseYear(String releaseDate) {
        if (releaseDate != null && releaseDate.length() >= 4) {
            return releaseDate.substring(0, 4);
        } else {
            return releaseDate;
        }
    }
}
