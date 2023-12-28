import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { BoatListComponent } from "./boat/view/boat-list/boat-list.component";
import { BoatViewComponent } from "./boat/view/boat-view/boat-view.component";
import { BoatEditComponent } from "./boat/view/boat-edit/boat-edit.component";

export const routes: Routes = [
  {
    component: BoatListComponent,
    path: "characters"
  },
  {
    component: BoatViewComponent,
    path: "characters/:uuid"
  }
  ,
  {
    component: BoatEditComponent,
    path: "characters/:uuid/edit"
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
