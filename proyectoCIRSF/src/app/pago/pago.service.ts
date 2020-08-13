import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Pago} from './pago';
import {TipoPago} from './tipopago';

@Injectable({
  providedIn: 'root'
})
export class PagoService {

  private url: string = 'http://localhost:8030/api/pagos';
  
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  
  constructor(private http: HttpClient) { }

  create (pago:Pago, id:number ) : Observable <Pago>{
    return this.http.post<any>(`${this.url}/${id}`, pago, {headers: this.httpHeaders}); 
  }

  updatePago(pago: Pago): Observable<Pago>{
    return this.http.put<Pago>(`${this.url}/${pago.idPago}`,pago) ; 
  }

  getPagoCredito(id): Observable<Pago[]>{
    return this.http.get<Pago[]>(`${this.url}/credito/${id}`);
  }

  getTipoPagos(): Observable<TipoPago[]>{
    return this.http.get<TipoPago[]>(this.url + '/tipos');
  }



}

