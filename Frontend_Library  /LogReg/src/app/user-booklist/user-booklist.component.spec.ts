import { ComponentFixture, TestBed } from '@angular/core/testing';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import { UserBooklistComponent } from './user-booklist.component';
import {  Ng2SearchPipeModule } from 'ng2-search-filter';
describe('UserBooklistComponent', () => {
  let component: UserBooklistComponent;
  let fixture: ComponentFixture<UserBooklistComponent>;
  let button:HTMLElement;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserBooklistComponent ],
      imports:[HttpClientTestingModule, Ng2SearchPipeModule,ReactiveFormsModule,FormsModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserBooklistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    button=fixture.nativeElement.querySelector('buttton');
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
