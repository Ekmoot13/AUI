import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatTypeViewComponent } from './boat-type-view.component';

describe('BoatTypeViewComponent', () => {
  let component: BoatTypeViewComponent;
  let fixture: ComponentFixture<BoatTypeViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BoatTypeViewComponent]
    });
    fixture = TestBed.createComponent(BoatTypeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
