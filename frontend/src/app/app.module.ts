import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SearchComponent} from './domains/search/search.component';
import {PopularComponent} from './domains/popular/popular.component';
import {DetailsComponent} from './domains/details/details.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {HttpClientModule} from "@angular/common/http";
import { FooterComponent } from './components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    PopularComponent,
    DetailsComponent,
    NavbarComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
