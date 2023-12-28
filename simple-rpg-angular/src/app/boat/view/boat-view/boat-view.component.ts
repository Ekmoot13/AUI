import { Component, OnInit } from '@angular/core';
import { BoatService } from "../../service/boat.service";
import { ActivatedRoute, Router } from "@angular/router";
import { BoatDetails } from "../../model/boat-details";


@Component({
  selector: 'app-boat-view',
  templateUrl: './boat-view.component.html',
  styleUrls: ['./boat-view.component.css']
})
export class BoatViewComponent implements OnInit {

  boat: BoatDetails | undefined;

  constructor(private service: BoatService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getBoat(params['uuid'])
        .subscribe(boat => this.boat = boat)
    });
  }

}
