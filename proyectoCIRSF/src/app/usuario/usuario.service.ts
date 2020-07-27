import { Injectable } from '@angular/core';
import {Usuarios} from './Usuarios'; 
import {Observable} from 'rxjs';

import {HttpClient, HttpHeaders} from '@angular/common/http'; 

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private url: string = 'http://localhost:8030/api/usuarios'; 
 
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})

  constructor(private http: HttpClient) { }


  getUsuario(): Observable <Usuarios[]> {
     return this.http.get<Usuarios[]>(this.url);  // se hace un cast de GASTO 
  }

  create (gasto: Usuarios) : Observable <Usuarios>{
    return this.http.post<Usuarios>(this.url, gasto, {headers: this.httpHeaders}); 
  }
    

  searchg(valor: number): Observable<Usuarios[]>{
    return this.http.get<Usuarios[]>(`${this.url}/valorMayor/${valor}`);
  }
}
