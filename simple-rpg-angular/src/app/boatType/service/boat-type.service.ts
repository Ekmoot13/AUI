import { Injectable } from '@angular/core';

import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { BoatTypes } from "../model/boatTypes";
import {BoatTypeDetails} from "../model/boatType-details";
import {BoatTypeForm} from "../model/boatType-form";
import {Boats} from "../../boat/model/boats";

@Injectable({
  providedIn: 'root'
})
export class BoatTypeService {

  constructor(private http: HttpClient) {

  }

  getBoatTypes(): Observable<BoatTypes> {
    return this.http.get<BoatTypes>('/api/boatTypes');
  }

  getBoatType(uuid: string): Observable<BoatTypeDetails> {
    return this.http.get<BoatTypeDetails>('/api/boatTypes/' + uuid);
  }

  getBoatTypeBoats(uuid: string): Observable<BoatTypeDetails> {
    return this.http.get<BoatTypeDetails>('/api/boatTypes/' + uuid);
  }
  getBoats(uuid: string): Observable<Boats> {
    return this.http.get<Boats>('/api/boatTypes/' + uuid + '/boats');
  }

  putBoatType(uuid: string, request: BoatTypeForm): Observable<any> {
    return this.http.put('/api/boatTypes/' + uuid, request);
  }

  deleteBoatType(uuid: string): Observable<any> {
    return this.http.delete('/api/boatTypes/' + uuid);
  }

}
