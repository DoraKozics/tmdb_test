import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {CommentService} from "../../services/comment.service";
import {CommentCreationModel} from "../../models/commentCreation.model";

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent {

  commentForm: FormGroup;
  movieId: number | undefined;

  constructor(private formBuilder: FormBuilder,
              private activatedRoute: ActivatedRoute,
              private commentService: CommentService) {
    this.commentForm = this.formBuilder.group({
      "authorEmail": ['', Validators.required],
      "text": ['', Validators.required]
    })

    this.activatedRoute.paramMap.subscribe({
      next: paramMap => {
        const id: number = Number(paramMap.get('id'));
        if (id) {
          this.movieId = id;
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
