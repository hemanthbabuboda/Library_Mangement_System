import { ComponentFixture, TestBed } from '@angular/core/testing';
import {FormsModule,NgModel,NgModelGroup,ReactiveFormsModule} from '@angular/forms';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import { BrowserModule } from '@angular/platform-browser';
import { UserListComponent } from './user-list.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { NgModule } from '@angular/core';
import { HttpClient } from '@angular/common/http';
describe('UserListComponent', () => {
  let component: UserListComponent;
  let fixture: ComponentFixture<UserListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserListComponent ],
      imports:[HttpClientTestingModule,FormsModule,ReactiveFormsModule, Ng2SearchPipeModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
