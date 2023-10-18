import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from './book.model';

@Injectable({
  providedIn: 'root'
})
export class BookserviceService {

  constructor(private http:HttpClient) { }


  getbooks(){
    return this.http.get<Book[]>('http://localhost:8083/books');
  }

  addbook(book:Book)
  {
    return this.http.post<Book>('http://localhost:8083/books', book);
  
  }

  getBook(bookId:number){
    return this.http.get<Book>(`http://localhost:8083/books/${bookId}`);
  }

  getBookByCategory(category:string){
    return this.http.get<Book[]>(`http://localhost:8083/books/category/${category}`);
  }

  deletebook(bookId:number){
    return this.http.delete(`http://localhost:8083/books/${bookId}`);
  }

  updateBook(bookId:number, book:Book){
    return this.http.put<any>(`http://localhost:8083/books`,book);
  }
}
