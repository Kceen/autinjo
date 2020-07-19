import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoDetailViewComponent } from './auto-detail-view.component';

describe('AutoDetailViewComponent', () => {
  let component: AutoDetailViewComponent;
  let fixture: ComponentFixture<AutoDetailViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoDetailViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoDetailViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
