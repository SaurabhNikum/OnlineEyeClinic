import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestListUserComponent } from './test-list-user.component';

describe('TestListUserComponent', () => {
  let component: TestListUserComponent;
  let fixture: ComponentFixture<TestListUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestListUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestListUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
