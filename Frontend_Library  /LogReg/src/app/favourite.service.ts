import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Favourites } from './Favourites.model';

@Injectable({
  providedIn: 'root'
})
export class FavouriteService {
  private baseUrl="http://localhost:8082/wishlist";

  constructor(private httpClient:HttpClient) { }

  addToWishlist(fav:Favourites):Observable<Object>{
    console.log(fav);
    return this.httpClient.post(`${this.baseUrl}/add`,fav);

  }

  getFavouritesList(fav:Favourites[],emailId:Favourites["email"]):Observable<Favourites[]>{
      return this.httpClient.get<Favourites[]>(`${this.baseUrl}/getList/${emailId}`);
  }

  deleteBookById(emailId:Favourites["email"],bookId:Favourites["bookId"]):Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/delete/${emailId}/${bookId}`)
  }
}
