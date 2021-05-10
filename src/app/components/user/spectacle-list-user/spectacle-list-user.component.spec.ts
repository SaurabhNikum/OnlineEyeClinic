import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpectacleListUserComponent } from './spectacle-list-user.component';

describe('SpectacleListUserComponent', () => {
  let component: SpectacleListUserComponent;
  let fixture: ComponentFixture<SpectacleListUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpectacleListUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpectacleListUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
