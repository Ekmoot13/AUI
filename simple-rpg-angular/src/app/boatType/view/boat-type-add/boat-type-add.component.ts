import {Component, OnInit} from '@angular/core';
import {BoatTypeForm} from "../../../boatType/model/boatType-form";
import {BoatTypes} from "../../model/boatTypes";
import {BoatService} from "../../../boat/service/boat.service";
import {BoatTypeService} from "../../service/boat-type.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-boat-type-add',
  templateUrl: './boat-type-add.component.html',
  styleUrls: ['./boat-type-add.component.css']
})
export class BoatTypeAddComponent implements OnInit {
  uuid: string | undefined;
  boatType: BoatTypeForm = {name: ''};
  original: BoatTypeForm | undefined;

  constructor(
    private boatTypeService: BoatTypeService,
    private router: Router
  ) {
  }

  generateUUID(): string {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
      const r = (Math.random() * 16) | 0;
      const v = c === 'x' ? r : (r & 0x3) | 0x8;
      return v.toString(16);
      //return 'f5875513-bf7b-4ae1-b8a5-5b70a1b90e71';
    });
  }

  ngOnInit() {
    this.original = {...this.boatType};
  }

  onSubmit(): void {
    this.uuid = this.generateUUID();
    console.log(this.boatType);
    console.log(this.uuid);
    this.boatTypeService.putBoatType(this.uuid!, this.boatType).subscribe(() => this.router.navigate(['/boatTypes']));
  }
}
