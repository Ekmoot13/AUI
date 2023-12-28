import {BoatType} from "../../boatType/model/boatType";

export interface BoatDetails{
  id:string;
  name:string;
  sailArea:number;
  boatType:BoatType;
}
