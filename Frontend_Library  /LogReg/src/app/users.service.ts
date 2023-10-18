import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IssueBook } from './issueBook.model';
import { LoginAuth } from './login.model';
import { User, Userl } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http:HttpClient) { }


  email!:string;

  getEmail(){
   return this.email;
 }
 setemail(Email:string){
   this.email=Email;
 }
 
  registerUser(user: User):Observable<Object>{
    
    return this.http.post<User>('http://localhost:8081/users',user);
  }


  loginUser(loginUser: LoginAuth):Observable<Object>{
    
    console.log(loginUser);
    return this.http.post<User>('http://localhost:8081/users/login',loginUser);
  }

  updatePassword(userId:number,user:Userl){
    console.log(userId)
    return this.http.put<any>('http://localhost:8081/users/changepassword/'+userId,user);
  }

  getUsers(role:any){
    console.log(role);
    return this.http.get<User[]>(`http://localhost:8081/users/role/${role}`);
  }

  deleteUser(userId:number):Observable<Object>{
    return this.http.delete(`http://localhost:8081/users/${userId}`);
  }

  getUsersByIssueDate(issueDate:IssueBook){
    return this.http.get<User[]>(`http://localhost:9093/issuebook/issuedate/${issueDate}`);
  }
  

}
