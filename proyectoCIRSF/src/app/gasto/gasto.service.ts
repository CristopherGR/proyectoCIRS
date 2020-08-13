import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http'; 

import {Usuarios} from '../usuario/usuarios';
import {Gasto} from './gasto'; 
import { TipoGasto } from './tipogasto';

@Injectable({
  providedIn: 'root'
})
export class GastoService {

  private url: string = 'http://localhost:8030/api/usuarios'; 
  private urlg: string = 'http://localhost:8030/api/gastos';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})

  constructor(private http: HttpClient) { }

  getUsuario(): Observable <Usuarios[]> {
    return this.http.get<Usuarios[]>(this.url + '/admin');  // se hace un cast de USUARIO
  }

  searchUsuario(nombre:string): Observable <Usuarios[]>{
    return this.http.get<Usuarios[]>(`${this.url}/nomadmin/${nombre}`);
  }

  getGasto(): Observable <Gasto[]> {
    return this.http.get<Gasto[]>(this.urlg); 
  }

  searchGasto(valor:string): Observable<Gasto[]>{
    let valores = Number(valor); 
    return this.http.get<Gasto[]>(`${this.urlg}/valorMayor/${valores}`);
  }

  create (gastos: Gasto, id: String) : Observable <Gasto>{
    return this.http.post<Gasto>(`${this.urlg}/${id}`, gastos, {headers: this.httpHeaders}); 
  }

  getTipoGasto(): Observable<TipoGasto[]>{
    return this.http.get<TipoGasto[]>(this.urlg + '/tipos'); 
  }

  getGastoUsuario(id:String): Observable<Gasto[]>{
    return this.http.get<Gasto[]>(`${this.urlg}/usuario/${id}`)
  }

}
