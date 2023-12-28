import {Component, OnInit} from '@angular/core';
import { BoatService } from '../../service/boat.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BoatForm } from '../../model/boat-form';
import { BoatTypeService } from "../../../boatType/service/boat-type.service";
import { BoatTypes } from "../../../boatType/model/boatTypes";
import {FormsModule} from "@angular/forms";


@Component({
  selector: 'app-boat-edit',
  templateUrl: './boat-edit.component.html',
  styleUrls: ['./boat-edit.component.css']
})
export class BoatEditComponent implements OnInit {

  uuid: string | undefined;
  boat: BoatForm | undefined;
  original: BoatForm | undefined;
  boatTypes: BoatTypes | undefined;
  constructor(
    private boatService: BoatService,
    private boatTypeService: BoatTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.boatTypeService.getBoatTypes()
        .subscribe(boatTypes => this.boatTypes = boatTypes);

      this.boatService.getBoat(params['uuid'])
        .subscribe(boat => {
          this.uuid = boat.id;
          this.boat = {
            name: boat.name,
            sailArea: boat.sailArea,
            boatType: boat.boatType.id
          };
          this.original = {...this.boat};
        });
    });
  }

  onSubmit(): void {
    this.boatService.putBoat(this.uuid!, this.boat!)
      .subscribe(() => this.router.navigate(['/boats']));
  }

}
