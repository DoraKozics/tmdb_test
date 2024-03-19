import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PopularComponent} from "./domains/popular/popular.component";
import {DetailsComponent} from "./domains/details/details.component";

const routes: Routes = [
  {path: "", component: PopularComponent},
  {path: "popular", component: PopularComponent},
  {path: "details/:id", component: DetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
