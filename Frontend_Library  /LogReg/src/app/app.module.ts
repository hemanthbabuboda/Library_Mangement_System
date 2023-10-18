import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RegComponent } from './reg/reg.component';
import { LoginComponent } from './login/login.component';
import {MatCardModule} from '@angular/material/card';
import { HomeComponent } from './home/home.component';
import { NavComponent } from './nav/nav.component';
import { AuNavComponent } from './au-nav/au-nav.component';
import { AddBookComponent } from './add-book/add-book.component';
import { BookListComponent } from './book-list/book-list.component';
import { UpdatepasswordComponent } from './updatepassword/updatepassword.component';
import { SearchComponent } from './search/search.component';
import { UserListComponent } from './user-list/user-list.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { WishlistComponent } from './wishlist/wishlist.component';
import { UserBooklistComponent } from './user-booklist/user-booklist.component';
import { MybooksComponent } from './mybooks/mybooks.component';
import { NgToastModule } from 'ng-angular-popup';
import {MatButtonModule} from '@angular/material/button';
import { ReturnBookComponent } from './return-book/return-book.component';
import { IssueBookComponent } from './issue-book/issue-book.component';
import { DatePipe } from '@angular/common';
import { FooterComponent } from './footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    RegComponent,
    LoginComponent,
    BookListComponent,
    HomeComponent,
    NavComponent,
    AuNavComponent,
    AddBookComponent,
    UpdatepasswordComponent,
    SearchComponent,
    UserListComponent,
    WishlistComponent,
    UserBooklistComponent,
    MybooksComponent,
    ReturnBookComponent,
    IssueBookComponent,
    FooterComponent,
   
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule,
    NgToastModule,
    MatCardModule,
    MatButtonModule
  
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
