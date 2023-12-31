import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatTypeAddComponent } from './boat-type-add.component';

describe('BoatTypeAddComponent', () => {
  let component: BoatTypeAddComponent;
  let fixture: ComponentFixture<BoatTypeAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BoatTypeAddComponent]
    });
    fixture = TestBed.createComponent(BoatTypeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
