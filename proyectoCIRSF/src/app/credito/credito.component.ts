import { Component, OnInit } from '@angular/core';


import {Creditos} from './credito'; 
import {CreditoService} from './credito.service'; 
import swal from 'sweetalert2';

@Component({
  selector: 'app-credito',
  templateUrl: './credito.component.html',
  styleUrls: ['./credito.component.css']
})
export class CreditoComponent implements OnInit {

  creditos: Creditos[]; 
  tipo: string; 
  valor: string; 

  constructor(private creditoService:CreditoService ) { }

  ngOnInit(): void {
    this.showAllCreditos();
  }

  
  filtro() {
    
    if(this.valor === ""){
      this.showAllCreditos();
    }else {
      this.searchUsuarioAdmin();
    }
  }


  showAllCreditos(){
    this.creditoService.getCredito().subscribe(
      creditos => this.creditos = creditos
    );
  }

  searchUsuarioAdmin(){
    let valors = Number(this.valor)

    this.creditoService.searchGasto(valors).subscribe(
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


}
