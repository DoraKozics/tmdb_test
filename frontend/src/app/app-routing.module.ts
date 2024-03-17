import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PopularComponent} from "./domains/popular/popular.component";

const routes: Routes = [
  {path: "", component: PopularComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
