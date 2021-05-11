import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateSpectacleComponent } from './update-spectacle.component';

describe('UpdateSpectacleComponent', () => {
  let component: UpdateSpectacleComponent;
  let fixture: ComponentFixture<UpdateSpectacleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateSpectacleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateSpectacleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
