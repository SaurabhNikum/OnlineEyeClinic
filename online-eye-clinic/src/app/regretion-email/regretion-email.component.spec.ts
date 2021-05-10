import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegretionEmailComponent } from './regretion-email.component';

describe('RegretionEmailComponent', () => {
  let component: RegretionEmailComponent;
  let fixture: ComponentFixture<RegretionEmailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegretionEmailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegretionEmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
