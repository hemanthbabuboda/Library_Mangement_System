
import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';
import { Book } from '../book.model';
import { BookserviceService } from '../bookservice.service';
import { IssueBookServiceService } from '../issue-book-service.service';
import { IssueBook } from '../issueBook.model';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-issue-book',
  templateUrl: './issue-book.component.html',
  styleUrls: ['./issue-book.component.css']
})
export class IssueBookComponent {


  books:Book[]=[];
  email:string=this.userService.getEmail();
   bookid:number;
  issueBook:IssueBook=new IssueBook();
  errormsg:any;

  constructor(private userService:UsersService,private bookService: BookserviceService,private issueService:IssueBookServiceService,private toast:NgToastService ,private datePipe:DatePipe){

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
  issue(book:Book){
   

    console.log(this.email)
    console.log(book)
    this.issueBook.email=this.email;
    this.issueBook.bookId=book.bookId;
    this.issueBook.bookName=book.bookName;
    this.issueBook.bookPic=book.bookPic;
    this.issueBook.issueDate=this.datePipe.transform(new Date(), "yyyy-MM-dd");
    this.issueBook.dueDate=this.issueBook.issueDate;

    console.log(this.issueBook.email);
    console.log(this.issueBook);
    this.issueService.issueBook(this.issueBook).subscribe(data=>{
      this.toast.success({detail:"Success",summary:'Book Issued',duration:3000})
    },
    error=>{
     this.errormsg=error.error
     if((this.errormsg)==("Book with given id already Issued to user")){
      this.toast.error({detail:"Failed",summary:"Book with given id already Issued to user",duration:3000});
     }
     else if((this.errormsg)==("Limit exceed, Three Books already Issued")){
      this.toast.error({detail:"Failed",summary:"Limit exceed, Three Books already Issued",duration:3000});
     }
     else{
      this.toast.error({detail:"Failed",summary:"Book Can't Issued, check again!",duration:3000});
     }
    }
      )
  }
}