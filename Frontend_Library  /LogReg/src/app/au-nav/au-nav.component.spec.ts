import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuNavComponent } from './au-nav.component';

describe('AuNavComponent', () => {
  let component: AuNavComponent;
  let fixture: ComponentFixture<AuNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuNavComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AuNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
