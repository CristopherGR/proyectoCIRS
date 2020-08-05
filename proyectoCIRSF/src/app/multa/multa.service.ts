import { Injectable } from '@angular/core';

import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http'; 
import { TipoMultas } from './tipomulta';
import {Multas} from './multa'; 

@Injectable({
  providedIn: 'root'
})
export class MultaService {

  private url: string = 'http://localhost:8030/api/multas'; 
 
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})

  constructor(private http: HttpClient) { }


  create (multa: Multas) : Observable <Multas>{
    return this.http.post<Multas>(this.url, multa, {headers: this.httpHeaders}); 
  }

  getTipo(): Observable <TipoMultas[]>{
    return this.http.get<TipoMultas[]>(this.url + '/tipo'); 
 }

 getMutla(): Observable<Multas[]>{
   return this.http.get<Multas[]>(this.url); 
 }

 updateMulta(multas: Multas): Observable<Multas>{
   return this.http.post<Multas>(`${this.url}/${multas.idMulta}`, multas); 
 }  
}
