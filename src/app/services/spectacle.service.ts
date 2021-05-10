import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Spectacle } from '../class/spectacle';

@Injectable({
  providedIn: 'root'
})
export class SpectacleService {

  constructor(private http:HttpClient) { }

  baseUrl:string="http://localhost:9090/onlineeyecare/spectacle";

  public addSpectacle(spectacle:Spectacle):Observable<Spectacle>
  {
    return this.http.post<Spectacle>(`${this.baseUrl}`,spectacle);
  }

  public getSpectacles():Observable<Spectacle[]>
  {
    return this.http.get<Spectacle[]>(`${this.baseUrl}`);
  }

  public getSpectacleById(id:number):Observable<Spectacle>
  {
    return this.http.get<Spectacle>(`${this.baseUrl}/${id}`);
  }

  public getSpectacleByModel(model:string):Observable<Spectacle[]>
  {
    return this.http.get<Spectacle[]>(`${this.baseUrl}/bymodel/${model}`);
  }

  public deleteSpectacle(id:number):Observable<Object>
  {
    return this.http.delete(`${this.baseUrl}/${id}`,{responseType: 'text'});
  }

  public updateSpectacle(id:number,spectacle:Spectacle):Observable<Spectacle>
  {
    return this.http.put<Spectacle>(`${this.baseUrl}/${id}`,spectacle);
  }
}
