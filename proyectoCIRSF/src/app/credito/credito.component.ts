import { Component, OnInit } from '@angular/core';


import {Creditos} from './credito'; 
import {CreditoService} from './credito.service'; 
import swal from 'sweetalert2';
import { ActivatedRoute } from '@angular/router';
import { TipoCreditos } from './tipocredito';

@Component({
  selector: 'app-credito',
  templateUrl: './credito.component.html',
  styleUrls: ['./credito.component.css']
})
export class CreditoComponent implements OnInit {

  creditos: Creditos[]; 
  tipo: string; 
  valor: string; 
  credito: Creditos = new Creditos();
  tipocredito: TipoCreditos[];

  constructor(private creditoService:CreditoService, private activated:ActivatedRoute ) { }

  ngOnInit(): void {
    this.showAllCreditos();
    this.showTipo();
  }

  
  filtro() {
    
    if(this.valor === ""){
      this.showAllCreditos();
    }else {
      this.searchUsuarioAdmin();
    }
  }


  showAllCreditos(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        console.log(id)
        this.creditoService.getCreditoUser(id).subscribe(credito => { this.creditos = credito})
      }
     });   
  }

  searchUsuarioAdmin(){
    let valors = Number(this.valor)

    this.creditoService.searchCreditoValor(valors).subscribe(
      creditos => {
        if(creditos === []){
          console.log(creditos)
          swal.fire('Aviso', 'No se encontro ningun credito', 'error')
          this.creditos = creditos
        }
        else{
          this.creditos = creditos
        }
      }
    )
  }

  showTipo(){
     this.creditoService.getTipoCredito().subscribe(
       tipoCredito => {
         console.log(tipoCredito);
         this.tipocredito = tipoCredito
        }
     ) 
  }


  creat(){
    let cont = 0;
    for(var i = 0; i < this.creditos.length; i++)
    { 
      let credito = this.creditos[i]
      if (credito.idEstado.descripcion === "activo")
       cont++;
    }

    if (cont>0){
      console.log("no se puede crear")
      
    }else {
      this.activated.params.subscribe(parametros => {
        let id = parametros['id']
        if(id){
          console.log(id)
          this.credito.interes = this.interes();
          this.credito.totalPagar = this.total();  
          this.creditoService.create(this.credito, id).subscribe( 
            nuevo => {console.log("credito creado")})
        }
       });
    }
  }

 

  interes(): number {
      return this.credito.valor*0.15;

  }

  total(): number{
      return this.credito.valor + this.credito.interes 
  }

  estado(): number{
    return 1
  }

}
  
  


