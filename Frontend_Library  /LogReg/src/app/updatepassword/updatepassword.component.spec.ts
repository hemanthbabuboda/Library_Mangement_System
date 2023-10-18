import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { NgToastService } from 'ng-angular-popup';
import { of } from 'rxjs';
import { Userl } from '../user.model';
import { UsersService } from '../users.service';
import { UpdatepasswordComponent } from './updatepassword.component';

describe('UpdatepasswordComponent', () => {
  let component: UpdatepasswordComponent;
  let fixture: ComponentFixture<UpdatepasswordComponent>;
  let userServiceSpy: jasmine.SpyObj<UsersService>;
  let toastSpy: jasmine.SpyObj<NgToastService>;

  beforeEach(async () => {
    const userSpy = jasmine.createSpyObj('UsersService', ['updatePassword']);
    const toastSpy = jasmine.createSpyObj('NgToastService', ['success']);
    await TestBed.configureTestingModule({
      imports: [ReactiveFormsModule, RouterTestingModule],
      declarations: [UpdatepasswordComponent],
      providers: [
        { provide: UsersService, useValue: userSpy },
        { provide: NgToastService, useValue: toastSpy }
      ]
    })
    .compileComponents();

    userServiceSpy = TestBed.inject(UsersService) as jasmine.SpyObj<UsersService>;
    // toastSpy = TestBed.inject(NgToastService) as jasmine.SpyObj<NgToastService>;
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatepasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should initialize the form', () => {
    expect(component.registrationForm.valid).toBeFalsy();
  });

  it('should update password successfully', () => {
    // Arrange
    const userId = 1;
    const user: Userl = { oldpassword: 'old', newpassword: 'new' };
    userServiceSpy.updatePassword.and.returnValue(of('OK'));

    // Act
    component.registrationForm.setValue(user);
    component.updatePassword();

    // Assert
    expect(userServiceSpy.updatePassword).toHaveBeenCalledWith(userId, user);
    expect(toastSpy.success).toHaveBeenCalled();
    expect(component.isSuccess).toBeTrue();
    expect(component.errormsg).toBeUndefined();
  });

  // it('should handle error when updating password', () => {
  //   // Arrange
  //   const userId = 1;
  //   const user: Userl = { oldpassword: 'old', newpassword: 'new' };
  //   const errorMsg = { message: 'error' };
  //   userServiceSpy.updatePassword.and.returnValue(throwError(errorMsg));

  //   // Act
  //   component.registrationForm.setValue(user);
  //   component.updatePassword();

  //   // Assert
  //   expect(userServiceSpy.updatePassword).toHaveBeenCalledWith(userId, user);
  //   expect(component.isSuccess).toBeFalse();
  //   expect(component.errormsg).toEqual(errorMsg);
  // });
});
