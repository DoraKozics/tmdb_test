import {Component} from '@angular/core';
import {MovieService} from "../../services/movie.service";
import {MovieListItemModel} from "../../models/movieListItem.model";

@Component({
  selector: 'app-popular',
  templateUrl: './popular.component.html',
  styleUrls: ['./popular.component.scss']
})
export class PopularComponent {

  popularMovies: MovieListItemModel[] = [];

  constructor(private movieService: MovieService) {
    this.getPopularMovies();
  }

  getPopularMovies = () => {
    this.movieService.getPopularMovies().subscribe({
      next: (response) => {
        this.popularMovies = response;
      }
    })
  }
}
