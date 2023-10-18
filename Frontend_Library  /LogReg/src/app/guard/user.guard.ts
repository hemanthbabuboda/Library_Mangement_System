import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {
  constructor(private router:Router ){}
  email=localStorage.getItem('emailId');
  canActivate(
    
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      // if(localStorage.getItem('emailId')!='admin@gmail.com' && localStorage.getItem("emailId")!=null){
      //   return true;
      // }
      if(localStorage.getItem('role')!='Admin' && localStorage.getItem("emailId")!=null){
        return true;
      }
      else{
        this.router.navigate(['/'])
        return false;
      }
  }
}