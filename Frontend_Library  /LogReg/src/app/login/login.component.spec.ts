import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login.component';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import { Router } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';


describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports:[HttpClientTestingModule,ReactiveFormsModule,FormsModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it("form is invalid when details empty",()=>{
    expect(component.commonloginform.valid).toBeFalsy();
  })
  it('email field validity',()=>{
    let email=component.commonloginform.controls['email'];
    expect(email.valid).toBeFalsy();
  })
  it('Form should be invalid when email is empty',()=>{
    let email=component.commonloginform.controls['email'];
    email.setValue('');
    expect(email.valid).toBeFalsy()
  })
  
  it('check invalid email address',()=>{
    const email=component.commonloginform.controls['email'];
    email.setValue('testmail');
    expect(email.valid).toBeFalsy()
  })
  it('check valid email address',()=>{
    const email=component.commonloginform.controls['email'];
    email.setValue('testmail@gmail.com');
    expect(email.valid).toBeTruthy()
  })

  it('Form should be invalid when password is empty',()=>{
    let password=component.commonloginform.controls['password'];
    password.setValue('');
    expect(password.valid).toBeFalsy()
  })

  it('check invalid password',()=>{
    const password=component.commonloginform.controls['password'];
    password.setValue('dsf');
    expect(password.valid).toBeFalsy()
  })
  it('check valid password',()=>{
    const password=component.commonloginform.controls['password'];
    password.setValue('Pass@123');
    expect(password.valid).toBeTruthy()
  })
  it('submit button disabled when given correct details',()=>{
    const email=component.commonloginform.controls['email'];
    const password=component.commonloginform.controls['password'];
    email.setValue('testmail@gmail.com');
    password.setValue('Pass@123');
    const submit=component.commonloginform.disabled;
    expect(submit).toBeFalsy();
  })

  // it('navigate to',()=>{
  //   const email=component.commonloginform.controls['email'];
  //   const password=component.commonloginform.controls['password'];
  //   email.setValue('admin@gmail.com');
  //   password.setValue('Admin@123');
  //   component.validateLogin(component.commonloginform);/
  // })
  
});
