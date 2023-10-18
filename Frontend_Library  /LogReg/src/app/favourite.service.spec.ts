import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { FavouriteService } from './favourite.service';
import { Favourites } from './Favourites.model';

describe('FavouriteService', () => {
  let service: FavouriteService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [FavouriteService]
    });

    service = TestBed.inject(FavouriteService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should add a book to wishlist via POST', () => {
    const newFav: Favourites = {
    favId:8,
    email:'testmail@gmail.com',
    bookId:2,
    bookName:'bookname1',
    author:'author1',
    category:'Science',
    bookPic:'',
    };

    service.addToWishlist(newFav).subscribe((response: any) => {
      expect(response).toBeTruthy();
    });

    const req = httpTestingController.expectOne('http://localhost:8082/wishlist/add');
    expect(req.request.method).toBe('POST');
    expect(req.request.body).toEqual(newFav);
    req.flush({ success: true });
  });

  it('should retrieve favourites list via GET', () => {
    const emailId = 'test@test.com';
    const mockFavs: Favourites[] = [
      { 
    favId:8,
    email:'testmail@gmail.com',
    bookId:2,
    bookName:'bookname1',
    author:'author1',
    category:'Science',
    bookPic:'',
      },
      { 
    favId:2,
    email:'testmail2@gmail.com',
    bookId:22,
    bookName:'bookname12',
    author:'author12',
    category:'others',
    bookPic:'',
       }
    ];

    service.getFavouritesList(mockFavs, emailId).subscribe((favs: Favourites[]) => {
      expect(favs).toEqual(mockFavs);
    });

    const req = httpTestingController.expectOne(`http://localhost:8082/wishlist/getList/${emailId}`);
    expect(req.request.method).toBe('GET');
    req.flush(mockFavs);
  });

  it('should delete a book from wishlist via DELETE', () => {
    const emailId = 'test@test.com';
    const bookId = 1;

    service.deleteBookById(emailId, bookId).subscribe((response: any) => {
      expect(response).toBeTruthy();
    });

    const req = httpTestingController.expectOne(`http://localhost:8082/wishlist/delete/${emailId}/${bookId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush({ success: true });
  });
});
