import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { Book } from './book.model';
import { BookserviceService } from './bookservice.service';

describe('BookserviceService', () => {
  let service: BookserviceService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [BookserviceService]
    });

    service = TestBed.inject(BookserviceService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should retrieve books from the API via GET', () => {
    const mockBooks: Book[] = [
      { bookId: 1, bookName: 'Book 1', author: 'Author 1', category:'Environment',quantity:22,bookPic:'' },
      { bookId: 2, bookName: 'Book 2', author: 'Author 2', category:'Others',quantity:2,bookPic:'' }
    ];

    service.getbooks().subscribe((books: Book[]) => {
      expect(books).toEqual(mockBooks);
    });

    const req = httpTestingController.expectOne('http://localhost:8083/books');
    expect(req.request.method).toBe('GET');
    req.flush(mockBooks);
  });

  it('should add a book via POST', () => {
    const newBook: Book = { bookId: 3, bookName: 'Book 3', author: 'Author 3', category:'Others',quantity:2,bookPic:'' };

    service.addbook(newBook).subscribe((book: Book) => {
      expect(book).toEqual(newBook);
    });

    const req = httpTestingController.expectOne('http://localhost:8083/books');
    expect(req.request.method).toBe('POST');
    expect(req.request.body).toEqual(newBook);
    req.flush(newBook);
  });

  it('should retrieve a single book via GET', () => {
    const bookId = 1;
    const mockBook: Book = {bookId: 3, bookName: 'Book 3', author: 'Author 3', category:'Others',quantity:2,bookPic:''};

    service.getBook(bookId).subscribe((book: Book) => {
      expect(book).toEqual(mockBook);
    });

    const req = httpTestingController.expectOne(`http://localhost:8083/books/${bookId}`);
    expect(req.request.method).toBe('GET');
    req.flush(mockBook);
  });

  it('should delete a book via DELETE', () => {
    const bookId = 1;

    service.deletebook(bookId).subscribe();

    const req = httpTestingController.expectOne(`http://localhost:8083/books/${bookId}`);
    expect(req.request.method).toBe('DELETE');
  });

  it('should update a book via PUT', () => {
    const bookId = 1;
    const updatedBook: Book = { bookId: 3, bookName: 'Book 3', author: 'Author 3', category:'Others',quantity:2,bookPic:'' };

    service.updateBook(bookId, updatedBook).subscribe((response: any) => {
      expect(response).toBeTruthy();
    });

    const req = httpTestingController.expectOne(`http://localhost:8083/books`);
    expect(req.request.method).toBe('PUT');
    expect(req.request.body).toEqual(updatedBook);
    req.flush({ success: true });
  });
  });
