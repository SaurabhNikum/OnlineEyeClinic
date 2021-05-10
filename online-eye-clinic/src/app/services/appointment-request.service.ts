import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppointmentRequest } from '../class/appointment-request';

@Injectable({
  providedIn: 'root'
})
export class AppointmentRequestService {

  constructor(private http:HttpClient) { }

  baseUrl:string="http://localhost:9090/onlineeyeclinic/appointmentrequest";

  public createAppointmentRequest(appointmentRequest:AppointmentRequest):Observable<Object>
  {
    return this.http.post(`${this.baseUrl}`,appointmentRequest,{responseType: 'text'});
  }

  public deleteAppointmentRequest(id:number):Observable<Object>
  {
    return this.http.delete(`${this.baseUrl}/${id}`,{responseType: 'text'});
  }

  public getAppointmentRequest():Observable<AppointmentRequest[]>
  {
    return this.http.get<AppointmentRequest[]>(`${this.baseUrl}`);
  }

}
