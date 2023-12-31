import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatTypeEditComponent } from './boat-type-edit.component';

describe('BoatTypeEditComponent', () => {
  let component: BoatTypeEditComponent;
  let fixture: ComponentFixture<BoatTypeEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BoatTypeEditComponent]
    });
    fixture = TestBed.createComponent(BoatTypeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
