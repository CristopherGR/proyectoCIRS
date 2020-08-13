import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsolicitudComponent } from './usolicitud.component';

describe('UsolicitudComponent', () => {
  let component: UsolicitudComponent;
  let fixture: ComponentFixture<UsolicitudComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsolicitudComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsolicitudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
