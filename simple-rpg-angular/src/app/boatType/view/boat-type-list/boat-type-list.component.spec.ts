import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoatTypeListComponent } from './boat-type-list.component';

describe('BoatTypeListComponent', () => {
  let component: BoatTypeListComponent;
  let fixture: ComponentFixture<BoatTypeListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BoatTypeListComponent]
    });
    fixture = TestBed.createComponent(BoatTypeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
