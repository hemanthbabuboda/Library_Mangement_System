import { Component, Input, OnInit, TestabilityRegistry } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-au-nav',
  templateUrl: './au-nav.component.html',
  styleUrls: ['./au-nav.component.css']
})
export class AuNavComponent implements OnInit {
  @Input() includeCommon = true;
   
  adminActivate:boolean=false;
  userActivate:boolean=false;

  constructor( private router:Router,private toast:NgToastService) { }
  
  ngOnInit(): void {
    this.router.events.subscribe(
      data =>{
        
        let  storeData:any=localStorage.getItem("emailId");
      //  console.log(storeData);
       if(storeData!=null && storeData=='admin@gmail.com' ){
        this.adminActivate=true;
      }
      else{
        this.adminActivate=false;
      }
      if(storeData!=null && storeData!='admin@gmail.com'){
        this.userActivate=true;
      }
      else{
        this.userActivate=false;
      }
    },
    error=>{
      console.log(error);
    })
  }
isLoggedIn():boolean{
  if(this.adminActivate || this.userActivate){
    return true;
  }
  else{
    return false;
  }
}
  logout(){
    localStorage.clear();
    this.toast.success({detail:"Done!",summary:'Logged out successfully',duration:3000})
    this.router.navigate(['/login']);

  }
  navBar(){
    if(localStorage.getItem("emailId")==null)
    return true;
    else
    return false;
  }
}

