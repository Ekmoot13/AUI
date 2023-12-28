import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Boats } from "../model/boats";
import { BoatDetails } from "../model/boat-details";
import { BoatForm } from "../model/boat-form";


@Injectable({
  providedIn: 'root'
})
export class BoatService {

  constructor(private http: HttpClient) {

  }

  getBoats(): Observable<Boats> {
    return this.http.get<Boats>('/api/boats');
  }

  getBoat(uuid: string): Observable<BoatDetails> {
    return this.http.get<BoatDetails>('/api/boats/' + uuid);
  }

  deleteBoat(uuid: string): Observable<any> {
    return this.http.delete('/api/boats/' + uuid);
  }

  putBoat(uuid: string, request: BoatForm): Observable<any> {
    return this.http.put('/api/boats/' + uuid, request);
  }

}
