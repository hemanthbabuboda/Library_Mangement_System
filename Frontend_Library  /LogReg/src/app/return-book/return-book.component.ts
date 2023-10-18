import { Component, OnInit } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';
import { IssueBookServiceService } from '../issue-book-service.service';
import { IssueBook } from '../issueBook.model';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-return-book',
  templateUrl: './return-book.component.html',
  styleUrls: ['./return-book.component.css']
})
export class ReturnBookComponent implements OnInit{


  issuebooks:IssueBook[]=[];
  email:string=this.userService.getEmail();

  constructor(private issueService:IssueBookServiceService,private userService:UsersService, private toast:NgToastService){

  }

  ngOnInit(): void {
    this.issueList();
 }
  issueList(){
   console.log(this.email);
   this.issueService.getIssueBookList(this.issuebooks,this.email).subscribe(data=>{
     console.log(data);
     this.issuebooks=data;
   });
 } 

 return(returnbook: IssueBook) {

  this.issueService.returnBook(returnbook).subscribe(data=>{
    console.log(data);
    this.ngOnInit();
    // alert("book deleted successfully...")
    this.toast.success({detail:"Success",summary:'Returned successfully',duration:3000})
  },
  error=>this.toast.error({detail:"Failed",summary:'failed to return',duration:3000}))
}
}
