import { Injectable } from '@angular/core';
import {Usuarios} from './Usuarios'; 
import {TipoUsuario} from './tipo-usuario'; 
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

  create (usuarios: Usuarios) : Observable <Usuarios>{
    return this.http.post<Usuarios>(this.url, usuarios, {headers: this.httpHeaders}); 
  }
    
  searchg(cedula: string): Observable<Usuarios[]>{
    return this.http.get<Usuarios[]>(`${this.url}/nombres/${cedula}`);
  }

  getTipoUsuario(): Observable <TipoUsuario[]>{
    return this.http.get<TipoUsuario[]>(this.url + '/tipos');
  }

  getUsuarioAdmin(): Observable <Usuarios[]> {
    return this.http.get<Usuarios[]>(this.url + '/admin');  // se hace un cast de USUARIO
  }

  getUsuarioId(id): Observable<Usuarios>{
    return this.http.get<Usuarios>(`${this.url}/${id}`);
  }

  update(usuarios: Usuarios): Observable<Usuarios>{
    return this.http.put<Usuarios>(`${this.url}/${usuarios.ciUsuario}`, usuarios);
  }
}
