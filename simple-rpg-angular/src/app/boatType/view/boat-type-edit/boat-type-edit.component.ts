import {Component, OnInit} from '@angular/core';
import {BoatForm} from "../../../boat/model/boat-form";
import {BoatTypes} from "../../model/boatTypes";
import {BoatService} from "../../../boat/service/boat.service";
import {BoatTypeService} from "../../service/boat-type.service";
import {ActivatedRoute, Router} from "@angular/router";
import {BoatTypeForm} from "../../model/boatType-form";

@Component({
  selector: 'app-boat-type-edit',
  templateUrl: './boat-type-edit.component.html',
  styleUrls: ['./boat-type-edit.component.css']
})
export class BoatTypeEditComponent implements OnInit {

  uuid: string | undefined;
  boatType: BoatTypeForm | undefined;
  original: BoatTypeForm | undefined;
  constructor(
    private boatTypeService: BoatTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.boatTypeService.getBoatType(params['uuid'])
        .subscribe(boatType => {
          this.uuid = boatType.id;
          this.boatType = {
            name: boatType.name,
          };
          this.original = {...this.boatType};
        });
    });
  }

  onSubmit(): void {
    this.boatTypeService.putBoatType(this.uuid!, this.boatType!)
      .subscribe(() => this.router.navigate(['/boatTypes']));
  }

}
