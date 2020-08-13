import { Component, OnInit } from '@angular/core';

import {Pago} from './pago'; 
import {PagoService} from './pago.service'; 
import swal from 'sweetalert2';
import { ActivatedRoute } from '@angular/router';
import { TipoPago } from './tipopago';
import {Creditos} from '../credito/credito';
import {CreditoService} from '../credito/credito.service';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-pago',
  templateUrl: './pago.component.html',
  styleUrls: ['./pago.component.css']
})

export class PagoComponent implements OnInit {

  pagos: Pago[]; 
  pago: Pago = new Pago(); 
  credito:Creditos;
  tipopago: TipoPago[];
  variable: number = 0 ;   

  constructor(private creditoService:CreditoService, private activated:ActivatedRoute, private pagoService:PagoService) { }

  ngOnInit(): void {
    this.showTipo();
    this.showCreditos();
    this.showPagos();
    this.atualizar();
    console.log(this.variable); 
  }


  showPagos(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        console.log(id)
        this.pagoService.getPagoCredito(id).subscribe(pago => { this.pagos = pago})
      }
     });
   
  }

  showTipo(){
    this.pagoService.getTipoPagos().subscribe(
      tipopago => {
        this.tipopago = tipopago
       }
    ) 
  }

  showCreditos(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        console.log(id)
        this.creditoService.getCreditoId(id).subscribe(credito => { this.credito = credito})
      }
     });   
  }


  creat(){
    if (this.credito.cuotas == this.credito.cuotasPagadas){
      console.log('no puede ingresar mas cuotas');
    }else{
      this.activated.params.subscribe(parametros => {
        let id = parametros['id']
        if(id){
            this.pagoService.create(this.pago, id).subscribe(() => { this.variable = this.variable + 1})  
        }
      });
    }
  } 
  
  atualizar(){
    if (this.variable > 0){
      this.credito.cuotasPagadas = this.credito.cuotasPagadas + 1; 
      this.creditoService.updateCredito(this.credito).subscribe( () => console.log(this.credito.cuotasPagadas) ); 
    } 
  }
  
}