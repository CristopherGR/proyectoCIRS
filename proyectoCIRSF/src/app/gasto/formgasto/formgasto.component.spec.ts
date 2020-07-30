import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormgastoComponent } from './formgasto.component';

describe('FormgastoComponent', () => {
  let component: FormgastoComponent;
  let fixture: ComponentFixture<FormgastoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormgastoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormgastoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
