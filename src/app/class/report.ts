
import { Patient } from "./patient";

export class Report 
{
    id:number;
    patientId:number;
    testId:number;
    reportDate:Date;
    description:string;
    visualAcuity:string;
    visualAcuityForNear:string;
    visualAcuityForDistance:string;
}
