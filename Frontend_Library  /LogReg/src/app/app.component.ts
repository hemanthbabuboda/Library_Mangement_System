import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LogReg';

  constructor(private router:Router){}
  ngOnInit(): void {

  }
  login(){
    if(localStorage.getItem('emailId')!=null)
    return true;
    else
    return false;
  }
  route(){
    if(this.router.url=='/login' || this.router.url=='/register')
    return false;
    else
    return true;
  }

}

