import { Component } from '@angular/core';
import { Book } from '../book.model';
import { BookserviceService } from '../bookservice.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent {

  books:Book[]=[];


  constructor(private bookService:BookserviceService){

  }


  ngOnInit(): void {


    this.bookService.getbooks().subscribe(
      data=>{
        this.books=data;
      },
      error=>{
        console.log(error)
      }
    )
  }

  onSelected(value:string): void {
	
    this.bookService.getBookByCategory(value).subscribe(
      data=>{
        this.books=data;
      },
      error=>{
        console.log(error)
      }
    )
	}
}
