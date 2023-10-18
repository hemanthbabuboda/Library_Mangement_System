import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IssueBook } from './issueBook.model';


@Injectable({
  providedIn: 'root'
})
export class IssueBookServiceService {

  constructor(private http:HttpClient) { }
  
  baseUrl='http://localhost:9093/issuebook';

  issueBook(issuebook: IssueBook):Observable<Object>
  {
    console.log(issuebook);
return this.http.post<IssueBook>(`${this.baseUrl}/issue`,issuebook);
  
  }

  getIssueBookList(issueBook:IssueBook[],email:IssueBook["email"]):Observable<IssueBook[]>{
    return this.http.get<IssueBook[]>(`${this.baseUrl}/getList/${email}`);
}



returnBook(returnbook: IssueBook):Observable<Object>{
  console.log(returnbook);
  return this.http.delete(`http://localhost:9094/returnbook/return/${returnbook.email}/${returnbook.bookId}`);
}
}
