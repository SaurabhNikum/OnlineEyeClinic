import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSpectacleComponent } from './create-spectacle.component';

describe('CreateSpectacleComponent', () => {
  let component: CreateSpectacleComponent;
  let fixture: ComponentFixture<CreateSpectacleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateSpectacleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSpectacleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
