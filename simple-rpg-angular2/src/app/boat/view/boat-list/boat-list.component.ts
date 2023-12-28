import { Component, OnInit } from '@angular/core';
import { BoatService } from "../../service/boat.service";
import { Boats } from "../../model/boats";
import { Boat } from "../../model/boat";
import {RouterLink} from "@angular/router";


@Component({
  selector: 'app-boat-list',
  standalone: true,
  imports: [
    RouterLink
  ],
  templateUrl: './boat-list.component.html',
  styleUrl: './boat-list.component.css'
})
export class BoatListComponent implements OnInit{

  constructor(private service: BoatService) {
  }

  boats: Boats | undefined;

  ngOnInit(): void {
    this.service.getBoats().subscribe(boats => this.boats = boats);
  }
  onDelete(boat: Boat): void {
    this.service.deleteBoat(boat.id).subscribe(() => this.ngOnInit());
  }

}
