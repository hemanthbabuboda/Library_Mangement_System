import { Component } from '@angular/core';
import { FormBuilder,FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { ToastrService } from 'ngx-toastr';
import { User } from '../user.model';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-reg',
  templateUrl: './reg.component.html',
  styleUrls: ['./reg.component.css']
})
export class RegComponent {
  registrationForm:FormGroup
  checkMatchingPassword(pass: string, passConfirm: string) {
    return (group: FormGroup) => {
      let password = group.controls[pass]
      let confirm = group.controls[passConfirm]

      if(password.value == confirm.value) {
        return;
      } else {
        confirm.setErrors({
          notEqualToPassword: true
        })
      }
    }
  }
  
  // registrationForm = new FormGroup({
  //   userid : new FormControl('',[Validators.required, Validators.pattern("[1-9]{1}[0-9]{3}")]),
  //   name : new FormControl('',[Validators.required,Validators.pattern('[a-zA-Z]*'),Validators.minLength(3),Validators.maxLength(12)]),
  //   email : new FormControl('',[Validators.required, Validators.email]),
  //   password : new FormControl('',[Validators.required, Validators.minLength(8),Validators.maxLength(15),Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')]),
  //   contact : new FormControl('',[Validators.required, Validators.minLength(10), Validators.maxLength(10), Validators.pattern("[6-9]{1}[0-9]{9}")]),
  //   cpassword : new FormControl('',[Validators.required])
  // }, {
  //   validator: this.checkMatchingPassword("password", "cpassword")
    
  // })
  // }
  ngOnInit(): void{
    this.registrationForm=this.formBuilder.group({
      'userid':new FormControl('',[Validators.required,Validators.pattern("[1-9]{1}[0-9]{3}")]),
      'name' : new FormControl('',[Validators.required,Validators.pattern('[a-zA-Z]*'),Validators.minLength(3),Validators.maxLength(12)]),
      'email' : new FormControl('',[Validators.required, Validators.email]),
      'password' : new FormControl('',[Validators.required, Validators.minLength(8),Validators.maxLength(15),Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{7,}')]),
      'contact' : new FormControl('',[Validators.required, Validators.min(6000000000), Validators.max(9999999999)]),
      'cpassword' : new FormControl('',[Validators.required])
    }, {
      validator: this.checkMatchingPassword("password", "cpassword")


    })
  }
  // {
  //   Validators:this.mustmatch('password','cpassword')
  // })

  get UserId(): FormControl{
    return this.registrationForm.get("userid") as FormControl
  }
  get UserName(): FormControl{
    return this.registrationForm.get("name") as FormControl
  }
  get EmailId(): FormControl{
    return this.registrationForm.get("email") as FormControl
  }
  get Password(): FormControl{
    return this.registrationForm.get("password") as FormControl
  }
  get Contact(): FormControl{
    return this.registrationForm.get("contact") as FormControl
  }
  get Cpassword(): FormControl{
    return this.registrationForm.get("cpassword") as FormControl
  }

  // mustmatch(controlName:string,matchingControlName:string)
  // {
  //   return (formgroup:FormGroup)=>{
  //     const control=formgroup.controls[controlName];
  //     const matchingControl=formgroup.controls[matchingControlName];
  //     if(matchingControl.errors && !matchingControl.errors.mustmatch){
  //       return 
  //     }
  //     if(control.value!==matchingControl.value){
  //       matchingControl.setErrors(this.mustmatch:true)
  //     }
  //     else{
  //       matchingControl.setErrors(null);
  //     }
  //   }
  // }
  

  constructor(private userService:UsersService,private router:Router,private formBuilder:FormBuilder,private toast:NgToastService){ }

  errormsg:null;
  isSuccess=false;
  

  user=new User();
  addUser(regForm : any){

    if(regForm.valid){

      //this.user.profilePic=this.pic;
      console.log(this.user);
     this.userService.registerUser(this.user).subscribe(
        data=>{
          
          this.toast.success({detail:"Success",summary:'User Registered Successfully',duration:3000})
          //alert('User Registered')
          this.isSuccess=true;
          this.router.navigate(['/login'])
          
        },
        error=>{
          this.toast.error({detail:"Oops!",summary:'Try with different userId',duration:3000})
          this.errormsg = error.error
           console.error("Here is your error: " + this.errormsg)
           console.log(error.error)
           if((error.error).equals("EmailId already exists"))
           this.errormsg=error.error
          
       
        }
      )
    }
    
    else{
      alert('somthing is wrong')
    }
  }

  // pic='';
  // onFileUpload(fileInput:any){
  //   let rdr=new FileReader();

  //   rdr.onload= (e:any)=>{
  //     let img=new Image();
  //     img.src=e.target.result;

  //     img.onload = rs=>{
  //       this.pic=e.target.result;
  //     }
  //   }

  //   rdr.readAsDataURL(fileInput.target.files[0]);


  // }
}
function ngOnInit() {
  throw new Error('Function not implemented.');
}

