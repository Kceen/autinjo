import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailSearchComponent } from './detail-search.component';

describe('DetailSearchComponent', () => {
  let component: DetailSearchComponent;
  let fixture: ComponentFixture<DetailSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
