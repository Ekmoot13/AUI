import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {BoatTypeDetails} from "../../model/boatType-details";
import {BoatTypeService} from "../../service/boat-type.service";
import {Boats} from "../../../boat/model/boats";

@Component({
  selector: 'app-boat-type-view',
  templateUrl: './boat-type-view.component.html',
  styleUrls: ['./boat-type-view.component.css']
})
export class BoatTypeViewComponent implements OnInit {

  boatType: BoatTypeDetails | undefined;
  boats: Boats | undefined;

  constructor(private service: BoatTypeService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getBoatType(params['uuid'])
        .subscribe(boatType => this.boatType = boatType)
    });

    this.route.params.subscribe(params => {
      this.service.getBoats(params['uuid'])
        .subscribe(boat => this.boats = boat)
    });
  }

}
