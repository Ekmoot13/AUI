import { Injectable } from '@angular/core';

import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { BoatTypes } from "../model/boatTypes";
import {BoatDetails} from "../../boat/model/boat-details";
import {BoatTypeDetails} from "../model/boatType-details";
import {BoatForm} from "../../boat/model/boat-form";
import {BoatTypeForm} from "../model/boatType-form";

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

  putBoatType(uuid: string, request: BoatTypeForm): Observable<any> {
    return this.http.put('/api/boatTypes/' + uuid, request);
  }

  deleteBoatType(uuid: string): Observable<any> {
    return this.http.delete('/api/boatTypes/' + uuid);
  }

}
