import { ComponentFixture, TestBed } from '@angular/core/testing';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import { RegComponent } from './reg.component';

describe('RegComponent', () => {
  let component: RegComponent;
  let fixture: ComponentFixture<RegComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegComponent ],
      imports:[HttpClientTestingModule,FormsModule,ReactiveFormsModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it("form is invalid when empty",()=>{
    expect(component.registrationForm.valid).toBeFalsy();
  })
  it("userId is invalid",()=>{
    let userid=component.registrationForm.controls['userid'];
    userid.setValue(10009);
    expect(userid.valid).toBeFalsy();
  })
  it("userId is valid",()=>{
    let userid=component.registrationForm.controls['userid'];
    userid.setValue(1009);
    expect(userid.valid).toBeTruthy();
  })
  it('check invalid name',()=>{
    const name=component.registrationForm.controls['name'];
    name.setValue('tl');
    expect(name.valid).toBeFalsy()
  })
  it('check valid name',()=>{
    const name=component.registrationForm.controls['name'];
    name.setValue('testname');
    expect(name.valid).toBeTruthy()
  })
  it('check invalid contact number',()=>{
    const con=component.registrationForm.controls['contact'];
    con.setValue(767765);
    expect(con.valid).toBeFalsy()
  })
  it('check invalid contact number',()=>{
    const con=component.registrationForm.controls['contact'];
    con.setValue(5689090987);
    expect(con.valid).toBeFalsy()
  })
  it('check valid contact number',()=>{
    const con=component.registrationForm.controls['contact'];
    con.setValue(7689090987);
    expect(con.valid).toBeTruthy()
  })
  it('Form should be invalid when email is empty',()=>{
    let email=component.registrationForm.controls['email'];
    email.setValue('');
    expect(email.valid).toBeFalsy()
  })
  
  it('check invalid email address',()=>{
    const email=component.registrationForm.controls['email'];
    email.setValue('testmail');
    expect(email.valid).toBeFalsy()
  })
  it('check valid email address',()=>{
    const email=component.registrationForm.controls['email'];
    email.setValue('testmail@gmail.com');
    expect(email.valid).toBeTruthy()
  })

  it('Form should be invalid when password is empty',()=>{
    let password=component.registrationForm.controls['password'];
    password.setValue('');
    expect(component.registrationForm.valid).toBeFalsy()
  })

  it('check invalid password',()=>{
    const password=component.registrationForm.controls['password'];
    password.setValue('dsf');
    expect(password.valid).toBeFalsy()
  })
  it('check valid password',()=>{
    const password=component.registrationForm.controls['password'];
    password.setValue('Pass@123');
    expect(password.valid).toBeTruthy()
  })

  it('Form should be invalid when confirm password is empty',()=>{
    let password=component.registrationForm.controls['cpassword'];
    password.setValue('');
    expect(component.registrationForm.valid).toBeFalsy()
  })

  it('check invalid confirm password',()=>{
    const password=component.registrationForm.controls['cpassword'];
    password.setValue('dsf');
    expect(password.valid).toBeFalsy()
  })

  // xit('check valid confirm password',()=>{
  //   const password=component.registrationForm.controls['cpassword'];
  //   password.setValue('Pass@123');
  //   expect(password.valid).toBeTruthy()
  // })
  // it('submit button open when given correct details',()=>{
  //   const email=component.registrationForm.controls['email'];
  //   const password=component.registrationForm.controls['password'];
  //   const userid=component.registrationForm.controls['userid'];
  //   const name=component.registrationForm.controls['name'];
  //   const contact=component.registrationForm.controls['contact'];
  //   const cpass=component.registrationForm.controls['cpass'];
  //   email.setValue('testmail@gmail.com');
  //   password.setValue('Pass@123');
  //   userid.setValue(1001);
  //   name.setValue("Hemanth");
  //   contact.setValue(8898988890);
  //   cpass.setValue('Pass@123')
  //   const submit=component.registrationForm.disabled;
  //   expect(component.registrationForm.valid).toBeTruthy();
  // })
});
