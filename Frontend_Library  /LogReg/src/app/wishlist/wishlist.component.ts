import { Component, OnInit } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';
import { FavouriteService } from '../favourite.service';
import { Favourites } from '../Favourites.model';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})

  export class WishlistComponent implements OnInit {

    fav!:Favourites;
    favourites!:Favourites[];
    email=localStorage.getItem("emailId");
    constructor(private service:FavouriteService, private toast:NgToastService) { }
  
    ngOnInit(): void {
       this.favList();
    }
    private favList(){
      console.log(this.email);
      this.service.getFavouritesList(this.favourites,localStorage.getItem("emailId")).subscribe(data=>{
        console.log(data);
        this.favourites=data;
      });
    } 
  
    deleted(bookId:number){
      console.log(this.email,bookId)
      this.service.deleteBookById(this.email,bookId).subscribe(data=>{
        this.ngOnInit();
        // alert("book deleted successfully...")
        this.toast.success({detail:"Success",summary:'Deleted successfully',duration:3000})
      },
      error=>this.toast.error({detail:"Failed",summary:'failed to delete',duration:3000}))
    }
}
