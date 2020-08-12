import { Component, OnInit } from '@angular/core';

import {Pago} from './pago'; 
import {PagoService} from './pago.service'; 
import swal from 'sweetalert2';
import { ActivatedRoute } from '@angular/router';
import { TipoPago } from './tipopago';
import {Creditos} from '../credito/credito';
import {CreditoService} from '../credito/credito.service';

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

  constructor(private creditoService:CreditoService, private activated:ActivatedRoute, private pagoService:PagoService) { }

  ngOnInit(): void {
    this.showTipo();
    this.showCreditos();
    this.showPagos();
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
          console.log(id)
          console.log(this.pago)
          this.pagoService.create(this.pago, id).subscribe( 
            nuevo => {console.log(this.pago)}) 
        }
       });
    }
  }  
      
}