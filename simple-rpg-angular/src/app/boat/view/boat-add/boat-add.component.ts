import { Component, OnInit } from '@angular/core';
import { BoatService } from '../../service/boat.service';
import { Router } from '@angular/router';
import { BoatForm } from '../../model/boat-form';
import { BoatTypeService } from '../../../boatType/service/boat-type.service';
import { BoatTypes } from '../../../boatType/model/boatTypes';

@Component({
  selector: 'app-boat-add',
  templateUrl: './boat-add.component.html',
  styleUrls: ['./boat-add.component.css'],
})
export class BoatAddComponent implements OnInit {
  uuid: string | undefined;
  boat: BoatForm = { name: '', sailArea: 0, boatType: '' };
  original: BoatForm | undefined;
  boatTypes: BoatTypes | undefined;

  constructor(
    private boatService: BoatService,
    private boatTypeService: BoatTypeService,
    private router: Router
  ) {}

  generateUUID(): string {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
      const r = (Math.random() * 16) | 0;
      const v = c === 'x' ? r : (r & 0x3) | 0x8;
      return v.toString(16);
      //return 'f5875513-bf7b-4ae1-b8a5-5b70a1b90e71';
    });
  }

  ngOnInit() {
    this.boatTypeService.getBoatTypes().subscribe((boatTypes) => (this.boatTypes = boatTypes));
    this.original = { ...this.boat };
  }

  onSubmit(): void {
    this.uuid = this.generateUUID();
    console.log(this.boat);
    console.log(this.uuid);
    this.boatService.putBoat(this.uuid!, this.boat).subscribe(() => this.router.navigate(['/boats']));
  }
}
