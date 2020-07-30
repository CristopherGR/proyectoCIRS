import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http'; 

import {Creditos} from './credito';
import { TipoCreditos } from './tipocredito';

@Injectable({
  providedIn: 'root'
})
export class CreditoService {

  private url: string = 'http://localhost:8030/api/creditos'; 
 
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
 
  constructor(private http: HttpClient) { }

  getCredito(): Observable <Creditos[]> {
    return this.http.get<Creditos[]>(this.url);  // se hace un cast de USUARIO
  }

 searchGasto(valor:number): Observable<Creditos[]>{
    return this.http.get<Creditos[]>(`${this.url}/valor/${valor}`);
  }
  
  searchGastoTipo(nombre:string): Observable <Creditos>{
    return this.http.get<Creditos>(`${this.url}/tipo/${nombre}`);
  }

  
  create (creditos: Creditos) : Observable <Creditos>{
    return this.http.post<Creditos>(this.url, creditos, {headers: this.httpHeaders}); 
  }

  getTipoCredito(): Observable<TipoCreditos[]>{
    return this.http.get<TipoCreditos[]>(this.url + '/tipos'); 
  }

}
