import { Component } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginAuth } from '../login.model';
import { User } from '../user.model';
import { UsersService } from '../users.service';
import { FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  commonloginform=new FormGroup({
    email: new FormControl('',[Validators.required,Validators.email]),
    password: new FormControl('',[Validators.required, Validators.minLength(8)] )

  })
 
  
  get Email(): FormControl{
    return this.commonloginform.get("email") as FormControl;
  }
  get Password(): FormControl{
    return this.commonloginform.get("password") as FormControl;
  }
  
  constructor(private userService:UsersService, private router:Router, private toast:NgToastService){ }

  ngOnInit(): void{

  }

  userLogin=new LoginAuth();
  user=new User();
  uservalid:any;
  // errormsg: null;
  // isSuccess= false;

  validateLogin(loginForm :any){

    if(loginForm.valid){
      // if(this.userLogin.role != "User")
      // {
      //   localStorage.setItem('emailId',this.userLogin.email);
      //   this.toast.success({detail:"Success",summary:"Admin Login Successful", duration:3000})
      //   this.router.navigate(['/booklist']);
      //   //console.log("admin")
      // }
      // else  {
        this.userService.loginUser(this.userLogin).subscribe(
          data=>{
            console.log(data);
            this.uservalid=data
            // localStorage.setItem('userid',this.uservalid.userId)
            if(this.uservalid==null){
              // alert("invalid email and password");
              this.toast.error({detail:"ERROR",summary:"Invalid email/password", duration:3000})
            }
            else if(this.uservalid.role !="Admin"){
            // this.isSuccess=true;
            localStorage.setItem('userid',this.uservalid.userId);
            localStorage.setItem('emailId',this.uservalid.email);
            localStorage.setItem('role',this.uservalid.role);
            this.toast.success({detail:"Success",summary:"User Login Successful", duration:3000})
              this.router.navigate(['/userbooklist']);
            
            }
            else if(this.uservalid.role != "User"){
              localStorage.setItem('emailId',this.userLogin.email);
              localStorage.setItem('role',this.uservalid.role);
              this.toast.success({detail:"Success",summary:"Admin Login Successful", duration:3000})
              this.router.navigate(['/booklist']);
            }  
            else{
              this.toast.error({detail:"ERROR",summary:"Invalid email/password", duration:3000})
            } 
        },
        error=>{
          console.log(error);
          // this.errormsg = error.error
          //  console.error("Here is your error: " + this.errormsg)
          //  console.log(error.error)
        }
        
      )
      }
    //}
    else{
      alert('someting is wrong')
    }
  }
  
}
