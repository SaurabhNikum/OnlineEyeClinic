import { Time } from "@angular/common";

export class Appointment 
{
    id:number;
    patientId:number;
    doctorId:number;
    appointmentDate:Date;
    appointmentTime:Time;
    consultationFee:number;
}
