import {Component, OnInit} from '@angular/core';
import {BoatTypeService} from "../../service/boat-type.service";
import {BoatTypes} from "../../model/boatTypes";
import {BoatType} from "../../model/boatType";

@Component({
  selector: 'app-boat-type-list',
  templateUrl: './boat-type-list.component.html',
  styleUrls: ['./boat-type-list.component.css']
})
export class BoatTypeListComponent implements OnInit{

  constructor(private service: BoatTypeService) {
  }

  boatTypes: BoatTypes | undefined;

  ngOnInit(): void {
    this.service.getBoatTypes().subscribe(boatTypes => this.boatTypes = boatTypes);
  }
  onDelete(boatType: BoatType): void {
    this.service.deleteBoatType(boatType.id).subscribe(() => this.ngOnInit());
  }

}
