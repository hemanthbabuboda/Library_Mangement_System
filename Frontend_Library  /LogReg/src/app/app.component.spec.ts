import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Component } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { NgToastComponent } from 'ng-angular-popup';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';

// describe('AppComponent', () => {
//   beforeEach(async () => {
//     let component: AppComponent;
//   let fixture: ComponentFixture<AppComponent>;
//     await TestBed.configureTestingModule({
//       imports: [
//         RouterTestingModule,
//       ],
//       declarations: [
//         AppComponent,
//         NavComponent
//       ],
//     }).compileComponents();
//     fixture = TestBed.createComponent(AppComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });

  // it('should create the app', () => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   const app = fixture.componentInstance;
  //   expect(app).toBeTruthy();
  // });

  // it(`should have as title 'LogReg'`, () => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   const app = fixture.componentInstance;
  //   expect(app.title).toEqual('LogReg');
  // });

  // it('should render title', () => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   fixture.detectChanges();
  //   const compiled = fixture.nativeElement as HTMLElement;
  //   expect(compiled.querySelector('.content span')?.textContent).toContain('LogReg app is running!');
  // });
// });
