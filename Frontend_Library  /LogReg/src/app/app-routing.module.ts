import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './add-book/add-book.component';
import { BookListComponent } from './book-list/book-list.component';
import { AdminGuard } from './guard/admin.guard';
import { LoginGuard } from './guard/login.guard';
import { UserGuard } from './guard/user.guard';

import { HomeComponent } from './home/home.component';
import { IssueBookComponent } from './issue-book/issue-book.component';

import { LoginComponent } from './login/login.component';
import { MybooksComponent } from './mybooks/mybooks.component';
import { RegComponent } from './reg/reg.component';
import { ReturnBookComponent } from './return-book/return-book.component';
import { UpdatepasswordComponent } from './updatepassword/updatepassword.component';
import { UserBooklistComponent } from './user-booklist/user-booklist.component';
import { UserListComponent } from './user-list/user-list.component';

import { WishlistComponent } from './wishlist/wishlist.component';

const routes: Routes = [
    {path:'',component:HomeComponent},
   {path:"login",component:LoginComponent,canActivate:[LoginGuard]},
   {path:"register",component:RegComponent,canActivate:[LoginGuard]},
   {path:"mybooks",component:MybooksComponent, canActivate:[UserGuard]},
   {path:"userbooklist",component:UserBooklistComponent, canActivate:[UserGuard]},
   {path:"wishlist",component:WishlistComponent, canActivate:[UserGuard]},
   {path:"changepassword",component:UpdatepasswordComponent, canActivate:[UserGuard]},
   {path:"addBook",component:AddBookComponent, canActivate:[AdminGuard]},
   {path:"booklist",component:BookListComponent, canActivate:[AdminGuard]},
   {path:"userlist",component:UserListComponent, canActivate:[AdminGuard]},
   {path:"issuebooklist",component:IssueBookComponent,canActivate:[AdminGuard]},
   {path:"returnbooklist",component:ReturnBookComponent,canActivate:[AdminGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AdminGuard,LoginGuard,UserGuard]
})
export class AppRoutingModule { }
