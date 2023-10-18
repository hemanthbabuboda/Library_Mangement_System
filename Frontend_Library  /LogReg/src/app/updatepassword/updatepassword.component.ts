import { Component } from '@angular/core';
import { FormGroup ,FormBuilder,FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { User, Userl } from '../user.model';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-updatepassword',
  templateUrl: './updatepassword.component.html',
  styleUrls: ['./updatepassword.component.css']
})
export class UpdatepasswordComponent {
oldpassword: any;
newpassword: any;
upass:string;
cpass:string;
users:Userl={
  oldpassword: '',
  newpassword: ''
}
  
  registrationForm:FormGroup
  isSuccess: boolean=false;
  errormsg: any;
  constructor(private userService:UsersService,private router:Router,private formBuilder:FormBuilder,private toast:NgToastService){ 
  }
ngOnInit(): void{
  this.registrationForm=this.formBuilder.group({
    'oldpassword' : new FormControl('',[Validators.required, Validators.minLength(8),Validators.maxLength(15),Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{7,}')]),
    'newpassword' : new FormControl('',[Validators.required, Validators.minLength(8),Validators.maxLength(15),Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{7,}')]),

  })

  
}

interval:any;
  nav() {
    this.interval = setTimeout(() => {
      localStorage.clear();
        this.router.navigate(["/login"])
    }, 3000);
  }
  
updatePassword() {
    this.users.oldpassword=this.registrationForm.value.oldpassword
    this.users.newpassword=this.registrationForm.value.newpassword
    let num: number = +(localStorage.getItem('userid')!)
    console.log("userid",num)
      this.userService.updatePassword(num,this.users).subscribe(
          data=>{
            console.log(data);
            this.toast.success({detail:"Updated Successfully!",summary:"login with new password", duration:3000});
            this.isSuccess=true;
            this.nav()
          },
          error=>{
            alert("failed to update new password");
            this.errormsg = error.error
           console.error("Here is your error: " + this.errormsg)
          }
        )
    console.log(this.registrationForm.value)
    }

    
 

}