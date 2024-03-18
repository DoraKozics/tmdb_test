import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {CommentCreationModel} from "../models/commentCreation.model";
import {Observable} from "rxjs";

const BASE_URL = environment.BASE_URL + "/api/comments";

@Injectable({
    providedIn: 'root'
})
export class CommentService {

    constructor(private http: HttpClient) {
    }

    createComment(comment: CommentCreationModel): Observable<any> {
        return this.http.post(BASE_URL, comment);
    }
}
