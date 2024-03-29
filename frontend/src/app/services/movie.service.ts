import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {MovieListItemModel} from "../models/movieListItem.model";
import {MovieDetailsModel} from "../models/movieDetails.model";

const BASE_URL = environment.BASE_URL + "/api/movies";

@Injectable({
  providedIn: 'root'
})

export class MovieService {

  constructor(private http: HttpClient) {
  }

  getPopularMovies(): Observable<MovieListItemModel[]> {
    return this.http.get<MovieListItemModel[]>(BASE_URL + "/popular");
  }

  getMovieDetails(id: Number): Observable<MovieDetailsModel> {
    return this.http.get<MovieDetailsModel>(BASE_URL + "/" + id);
  }
}
