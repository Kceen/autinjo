import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent implements OnInit {
  pageNumber: number = 0;
  isLastPage: string = localStorage.getItem("isLastPage");
  @Output() pageNumberEmmiter = new EventEmitter<number>();
  

  constructor() {
   }

  ngOnInit(): void {
  }

  onPageUp(pageNumber) {
    this.pageNumberEmmiter.emit(++pageNumber);
    this.pageNumber = pageNumber;
    this.isLastPage = localStorage.getItem("isLastPage");
    
  }

  onPageDown(pageNumber) {
    this.pageNumberEmmiter.emit(--pageNumber);
    this.pageNumber = pageNumber;
    
  }

}
