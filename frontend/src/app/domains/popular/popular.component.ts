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
  currentPage: number = 1;
  itemsPerPage: number = 9;

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

  getPaginatedMovies = () => {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.popularMovies.slice(startIndex, endIndex);
  }

  nextPage = () => {
    this.currentPage++;
  }

  previousPage = () => {
    this.currentPage--;
  }
}
