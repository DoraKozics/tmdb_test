import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PopularComponent} from "./domains/popular/popular.component";
import {SearchComponent} from "./domains/search/search.component";

const routes: Routes = [
  {path: "", component: PopularComponent},
  {path: "popular", component: PopularComponent},
  {path: "search", component: SearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
