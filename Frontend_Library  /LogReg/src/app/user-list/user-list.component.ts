import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { User } from '../user.model';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent {

  searchText:any;
  users:User[]=[];
  
  constructor(private userService:UsersService, private router:Router,private toast:NgToastService) { }

  ngOnInit(): void {
    // this.getUsers();
    this.getUsers(this.role);
  }

  interval:any;
  refresh() {
    this.interval = setTimeout(() => {
      location.reload()
    }, 3000);
  }

  onsubmit(usr:User){
    console.log(usr);
    this.userService.setemail(usr.email);

  }
  
  // getUsers():void{
    
  //   this.userService.getUsers().subscribe(
  //     data=>{
  //       this.users=data;
  //     },
  //     error=>{
  //       console.log(error)
  //     }
  //   )
  // }
  role:any="User";
  getUsers(role: any){
    
    this.userService.getUsers(role).subscribe(
      data=>{
        console.log(data);
        this.users=data;
      },
      error=>{
        console.log(error)
        console.log(error.error)
      }
    )
  }
 
  deleteUser(userId:number){
    this.userService.deleteUser(userId).subscribe(
      data=>{
        this.toast.success({detail:"Success",summary:"Deleted successfully", duration:3000});
        this.refresh();
      },
      error=>{
        console.log(error);
        alert("User not deleted");
      }
    )
  }

  searchbyIssueDate(date:any) {
    console.log(date.value);
    this.userService.getUsersByIssueDate(date.value).subscribe(
      data=>{
        this.users=data;
      },
      error=>{
        console.log(error)
        console.log(error.error)
      }
    )
  }
}
