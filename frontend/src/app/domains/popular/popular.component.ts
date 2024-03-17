import {Component} from '@angular/core';
import {MovieService} from "../../services/movie.service";

@Component({
  selector: 'app-popular',
  templateUrl: './popular.component.html',
  styleUrls: ['./popular.component.scss']
})
export class PopularComponent {

  constructor(private movieService: MovieService) {
    this.getPopularMovies();
  }

  getPopularMovies = () => {
    this.movieService.getPopularMovies().subscribe({
      next: (response) => {
        console.log(response);
      }
    })
  }
}
