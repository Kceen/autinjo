import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeDetailSearchComponent } from './home-detail-search.component';

describe('HomeDetailSearchComponent', () => {
  let component: HomeDetailSearchComponent;
  let fixture: ComponentFixture<HomeDetailSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeDetailSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeDetailSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
