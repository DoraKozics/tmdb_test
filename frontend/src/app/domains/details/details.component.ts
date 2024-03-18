import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {CommentService} from "../../services/comment.service";
import {CommentCreationModel} from "../../models/commentCreation.model";
import {CommentListItemModel} from "../../models/commentListItem.model";
import {MovieService} from "../../services/movie.service";
import {MovieDetailsModel} from "../../models/movieDetails.model";

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent {

  commentForm: FormGroup;
  movieId: number | undefined;
  movieDetails: MovieDetailsModel | undefined;
  comments: CommentListItemModel[] = [];

  constructor(private formBuilder: FormBuilder,
              private activatedRoute: ActivatedRoute,
              private commentService: CommentService,
              private movieService: MovieService) {
    this.commentForm = this.formBuilder.group({
      "authorEmail": ['', Validators.required],
      "text": ['', Validators.required]
    })

    this.activatedRoute.paramMap.subscribe({
      next: paramMap => {
        const id: number = Number(paramMap.get('id'));
        if (id) {
          this.movieId = id;
          this.movieService.getMovieDetails(this.movieId).subscribe({
            next: (details) => {
              this.movieDetails = details;
              console.log(this.movieDetails);
            }
          })

          this.commentService.getAllCommentsByMovie(this.movieId).subscribe({
            next: (comments) => {
              this.comments = comments;
            }
          })
        }
      }
    })
  }

  sendComment() {
    if (this.movieId) {
      let commentData: CommentCreationModel = this.commentForm.value;
      commentData.movieId = this.movieId;
      this.commentService.createComment(commentData).subscribe({
        next: () => {
        }
      })
    }
  }
}
