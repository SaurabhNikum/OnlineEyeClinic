import { Time } from "@angular/common";

export class AppointmentRequest 
{
    requestId:number;
    patientId:number;
    patientEmail:string;
    appointmentDate:Date;
    appointmentTime:Time;
}
