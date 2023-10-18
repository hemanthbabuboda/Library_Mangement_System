import { Component, OnInit } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';
import { IssueBookServiceService } from '../issue-book-service.service';
import { IssueBook } from '../issueBook.model';

@Component({
  selector: 'app-mybooks',
  templateUrl: './mybooks.component.html',
  styleUrls: ['./mybooks.component.css']
})
export class MybooksComponent implements OnInit{


  issuebooks:IssueBook[]=[];
  email=localStorage.getItem("emailId");

  constructor(private issueService:IssueBookServiceService,private toast:NgToastService){

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

}
