import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoatListComponent } from "./boat/view/boat-list/boat-list.component";
import { BoatViewComponent } from "./boat/view/boat-view/boat-view.component";
import { BoatEditComponent } from "./boat/view/boat-edit/boat-edit.component";
import {BoatTypeListComponent} from "./boatType/view/boat-type-list/boat-type-list.component";
import {BoatTypeViewComponent} from "./boatType/view/boat-type-view/boat-type-view.component";
import {BoatTypeEditComponent} from "./boatType/view/boat-type-edit/boat-type-edit.component";


const routes: Routes = [
  {
    component: BoatListComponent,
    path: "boats"
  },
  {
    component: BoatViewComponent,
    path: "boats/:uuid"
  }
  ,
  {
    component: BoatEditComponent,
    path: "boats/:uuid/edit"
  },
  {
    component: BoatTypeListComponent,
    path: "boatTypes"
  },
  {
    component: BoatTypeViewComponent,
    path: "boatTypes/:uuid"
  }
  ,
  {
    component: BoatTypeEditComponent,
    path: "boatTypes/:uuid/edit"
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
