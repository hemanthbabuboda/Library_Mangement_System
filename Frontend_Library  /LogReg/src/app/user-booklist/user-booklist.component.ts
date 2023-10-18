import { Component } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';
import { Book } from '../book.model';
import { BookserviceService } from '../bookservice.service';
import { FavouriteService } from '../favourite.service';
import { Favourites } from '../Favourites.model';

@Component({
  selector: 'app-user-booklist',
  templateUrl: './user-booklist.component.html',
  styleUrls: ['./user-booklist.component.css']
})
export class UserBooklistComponent {

  searchText: any;
  books:Book[]=[];
  fav:Favourites=new Favourites();
  email=localStorage.getItem("emailId");
  constructor(private bookService:BookserviceService,private fService:FavouriteService,private toast:NgToastService ){

  }

  ngOnInit(): void {


    this.bookService.getbooks().subscribe(
      data=>{
        this.books=data;
      },
      error=>{
        console.log(error)
      }
    )
  }
  interval:any;
  refresh() {
    this.interval = setTimeout(() => {
      location.reload()
    }, 3000);
  }
  wishlist(book:Book){

   
    console.log(this.email)
    console.log(book)
    this.fav.email=this.email;
    this.fav.bookId=book.bookId;
    this.fav.bookName=book.bookName;
    this.fav.author=book.author;
    this.fav.category=book.category;
    this.fav.bookPic=book.bookPic;
    console.log(this.fav.email);
    console.log(this.fav);
    this.fService.addToWishlist(this.fav).subscribe(data=>{
      // alert("Added to favourites!");
      this.toast.success({detail:"Success",summary:'Added to wishlist',duration:3000})
    },
    error=>this.toast.error({detail:"Failed",summary:"Can't add to wishlist, check again!",duration:3000}))
  }

}
