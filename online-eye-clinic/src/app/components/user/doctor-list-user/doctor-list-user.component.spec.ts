import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorListUserComponent } from './doctor-list-user.component';

describe('DoctorListUserComponent', () => {
  let component: DoctorListUserComponent;
  let fixture: ComponentFixture<DoctorListUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoctorListUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorListUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
