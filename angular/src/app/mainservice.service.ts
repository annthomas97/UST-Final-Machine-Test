import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Vendor } from './vendor';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MainserviceService {

  constructor(private _httpService: HttpClient) { }
  getVendors(): Observable<Vendor[]>{
    return this._httpService.get<Vendor[]>(environment.APIUrl +'/vendor');
  }

  searchVendors(searchString: string): Observable<Vendor[]>{
    return this._httpService.get<Vendor[]>(environment.APIUrl +'/searchVendor/'+ searchString);
  }
}
