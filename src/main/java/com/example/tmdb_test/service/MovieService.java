package com.example.tmdb_test.service;

import com.example.tmdb_test.dto.outgoing.MovieListItem;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Value("${tmdbApiKey}")
    private String key;

    @Value("${tmdbApiToken}")
    private String token;

    public List<MovieListItem> getPopularMovies() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/popular?language=en-US"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + token)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return mapPopularMoviesToDTO(response.body());
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
            String releaseYear = movieObject.getString("release_date").substring(0, 4);
            int voteAverage = movieObject.getInt("vote_average");
            int voteCount = movieObject.getInt("vote_count");
            String overview = movieObject.getString("overview");

            popularMovies.add(new MovieListItem(movieId, title, posterPath, releaseYear, voteAverage, voteCount, overview));
        }
        return popularMovies;
    }
}
