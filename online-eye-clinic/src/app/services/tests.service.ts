import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tests } from '../class/tests';


@Injectable({
  providedIn: 'root'
})
export class TestsService {


  private baseURL = "http://localhost:9090/onlineeyecare/tests";

  constructor(private httpClient: HttpClient) { }
  
  getTestsList(): Observable<Tests[]>{
    return this.httpClient.get<Tests[]>(`${this.baseURL}`);
  }

  getTestsListByName(name:string): Observable<Tests[]>{
    return this.httpClient.get<Tests[]>(`${this.baseURL}/byname/${name}`);
  }

  createTests(tests:Tests): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, tests);
  }

  getTestsId(id: number): Observable<Tests>{
    return this.httpClient.get<Tests>(`${this.baseURL}/${id}`);
  }

  updateTests(id: number, tests:Tests): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, tests);
  }

  deleteTests(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`,{responseType: 'text'});
  }

}
