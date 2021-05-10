import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Report } from '../class/report';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  private baseURL = "http://localhost:9090/onlineeyeclinic/report";

  constructor(private httpClient: HttpClient) { }

  getReportList(): Observable<Report[]>{
    return this.httpClient.get<Report[]>(`${this.baseURL}`);
  }

  createReport(report:Report): Observable<Report>{
    return this.httpClient.post<Report>(`${this.baseURL}`,  report);
  }

  getReportById(id: number): Observable<Report>{
    return this.httpClient.get<Report>(`${this.baseURL}/${id}`);
  }

  getReportByPatientId(id:number): Observable<Report[]>{
    return this.httpClient.get<Report[]>(`${this.baseURL}/bypatientid/${id}`);
  }

  updateReport(id:number,report:Report): Observable<Report>{
    return this.httpClient.put<Report>(`${this.baseURL}/${id}`,  report);
  }

  deleteReport(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`,{responseType: 'text'});
  }
}
