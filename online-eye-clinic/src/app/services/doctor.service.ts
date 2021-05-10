import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from '../class/doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private baseURL = "http://localhost:9090/onlineeyeclinic/doctor";

  constructor(private httpClient: HttpClient) { }

  getDoctorList(): Observable<Doctor[]>{
    return this.httpClient.get<Doctor[]>(`${this.baseURL}`);
  }

  createDoctor(doctor:Doctor): Observable<Doctor>{
    return this.httpClient.post<Doctor>(`${this.baseURL}`,  doctor);
  }

  getDoctorById(id: number): Observable<Doctor>{
    return this.httpClient.get<Doctor>(`${this.baseURL}/${id}`);
  }

  getDoctorByName(name: string): Observable<Doctor[]>{
    return this.httpClient.get<Doctor[]>(`${this.baseURL}/byname/${name}`);
  }

  getDoctorIdByUsername(name: string): Observable<Object>{
    return this.httpClient.get(`${this.baseURL}/byusername/${name}`,{responseType: 'text'});
  }

  updateDoctor(id: number, doctor:Doctor): Observable<Doctor>{
    return this.httpClient.put<Doctor>(`${this.baseURL}/${id}`,  doctor);
  }

  deleteDoctor(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`,{responseType: 'text'});
  }
}
