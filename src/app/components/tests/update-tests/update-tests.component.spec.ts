import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTestsComponent } from './update-tests.component';

describe('UpdateTestsComponent', () => {
  let component: UpdateTestsComponent;
  let fixture: ComponentFixture<UpdateTestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateTestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateTestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
