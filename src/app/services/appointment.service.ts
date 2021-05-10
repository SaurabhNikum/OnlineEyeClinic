import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../class/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(private http:HttpClient) { }

  baseUrl:string="http://localhost:9090/onlineeyeclinic/appointment";

  public createAppointment(appointment:Appointment):Observable<Appointment>
  {
    return this.http.post<Appointment>(`${this.baseUrl}`,appointment);
  }

  public getAppointment():Observable<Appointment[]>
  {
    return this.http.get<Appointment[]>(`${this.baseUrl}`);
  }

  public getAppointmentById(id:number):Observable<Appointment>
  {
    return this.http.get<Appointment>(`${this.baseUrl}/${id}`);
  }

  public getAppointmentByDoctor(id:number):Observable<Appointment[]>
  {
    return this.http.get<Appointment[]>(`${this.baseUrl}/bydoctor/${id}`);
  }
  public getAppointmentByPatient(id:number):Observable<Appointment[]>
  {
    return this.http.get<Appointment[]>(`${this.baseUrl}/bypatient/${id}`);
  }

  public getAppointmentByDate(date:Date):Observable<Appointment[]>
  {
    return this.http.get<Appointment[]>(`${this.baseUrl}/bydate/${date}`);
  }


  public deleteAppointment(id:number):Observable<Object>
  {
    return this.http.delete(`${this.baseUrl}/${id}`,{responseType: 'text'});
  }
}
