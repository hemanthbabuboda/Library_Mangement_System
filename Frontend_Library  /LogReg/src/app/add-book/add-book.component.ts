import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { Book } from '../book.model';
import { BookserviceService } from '../bookservice.service';



@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent {

  book:Book=new Book();
  pic:any='';
  constructor(private bookService:BookserviceService,private router:Router,private toast:NgToastService){}

  ngOninit(){}

      onFileUpload(fileInput:any){
        let rdr=new FileReader();
    
        rdr.onload= (e:any)=>{
          let img=new Image();
          img.src=e.target.result;
    
          img.onload = rs=>{
            this.pic=e.target.result;
          }
        }
      
    
        rdr.readAsDataURL(fileInput.target.files[0]);
      }
    

      addBook() {
    
        this.book.bookPic=this.pic;
        console.log(this.book.bookPic);
        this.bookService.addbook(this.book).subscribe(
          data=>{
           // alert("Book added");
            this.toast.success({detail:"Success",summary:'Book Added Successfully',duration:3000})
            this.router.navigate(['/booklist']);
          },
          error=>{
            this.toast.error({detail:"Oops!",summary:'Something went wrong,Try again',duration:3000})
            alert("Book cannot added");
          }
        )
      }
}
