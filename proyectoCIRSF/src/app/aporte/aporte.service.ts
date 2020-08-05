import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Aportes } from './aportes';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AporteService {

  private url: string = 'http://localhost:8030/api/aportes';
  
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  
  constructor(private http: HttpClient) { }
  
  create (aporte: Aportes) : Observable <Aportes>{
    return this.http.post<Aportes>(this.url, aporte, {headers: this.httpHeaders}); 
  }

  getAllAportes(): Observable <Aportes[]>{
    return this.http.get<Aportes[]>(this.url); 
  }

  updateAporte(aportes: Aportes): Observable<Aportes>{
    return this.http.put<Aportes>(`${this.url}/${aportes.idAporte}`, aportes); 
  }

  getAporteId(id): Observable<Aportes>{
    return this.http.get<Aportes>(`${this.url}/${id}`)
  }

}
