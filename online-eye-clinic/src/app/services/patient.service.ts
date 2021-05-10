import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patient } from '../class/patient'; 
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private baseURL = "http://localhost:9090/onlineeyeclinic/patient";

  constructor(private httpClient: HttpClient) { }

  getPatientList(): Observable<Patient[]>{
    return this.httpClient.get<Patient[]>(`${this.baseURL}`);
  }

  createPatient(patient:Patient): Observable<Patient>{
    return this.httpClient.post<Patient>(`${this.baseURL}`,  patient);
  }

  getPatientById(id: number): Observable<Patient>{
    return this.httpClient.get<Patient>(`${this.baseURL}/${id}`);
  }

  getPatientsByName(name: string): Observable<Patient[]>{
    return this.httpClient.get<Patient[]>(`${this.baseURL}/byname/${name}`);
  }

  getPatientIdByUserName(name: string): Observable<Object>{
    return this.httpClient.get(`${this.baseURL}/byusername/${name}`,{responseType: 'text'});
  }

  updatePatient(id: number, patient:Patient): Observable<Patient>{
    return this.httpClient.put<Patient>(`${this.baseURL}/${id}`,  patient);
  }

  deletePatient(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`,{responseType: 'text'});
  }
}
