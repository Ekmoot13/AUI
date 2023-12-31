import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { HttpClientModule } from "@angular/common/http";
import { BoatListComponent } from './boat/view/boat-list/boat-list.component';
import { BoatService } from './boat/service/boat.service';
import { BoatViewComponent } from './boat/view/boat-view/boat-view.component';
import { BoatEditComponent } from './boat/view/boat-edit/boat-edit.component';
import { FormsModule } from "@angular/forms";
import { BoatTypeViewComponent } from './boatType/view/boat-type-view/boat-type-view.component';
import { BoatTypeListComponent } from './boatType/view/boat-type-list/boat-type-list.component';
import { BoatTypeEditComponent } from './boatType/view/boat-type-edit/boat-type-edit.component';
import {BoatTypeService} from "./boatType/service/boat-type.service";
import { BoatAddComponent } from './boat/view/boat-add/boat-add.component';
import { BoatTypeAddComponent } from './boatType/view/boat-type-add/boat-type-add.component';


@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    BoatListComponent,
    BoatViewComponent,
    BoatEditComponent,
    BoatAddComponent,
    BoatTypeViewComponent,
    BoatTypeListComponent,
    BoatTypeEditComponent,
    BoatTypeAddComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    BoatService,
    BoatTypeService
  ],
  bootstrap: [
    AppComponent
  ]
})


export class AppModule { }
