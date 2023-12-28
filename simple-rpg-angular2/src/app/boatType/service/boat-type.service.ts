import { Injectable } from '@angular/core';

import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { BoatTypes } from "../model/boatTypes";

@Injectable({
  providedIn: 'root'
})
export class BoatTypeService {

  constructor(private http: HttpClient) {

  }

  getProfessions(): Observable<BoatTypes> {
    return this.http.get<BoatTypes>('/api/boatTypes');
  }


}
