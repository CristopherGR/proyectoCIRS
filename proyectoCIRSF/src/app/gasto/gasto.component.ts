import { Component, OnInit } from '@angular/core';
import { Usuarios } from '../usuario/Usuarios';
 
import {GastoService} from './gasto.service'; 

@Component({
  selector: 'app-gasto',
  templateUrl: './gasto.component.html',

})
export class GastoComponent implements OnInit {

  usuarios: Usuarios[]; 
  
  nombre: string; 
  valor: string; 

  constructor(private gastoService: GastoService) { }

  ngOnInit(): void {
    this.showAllUsuario();
  }

  filtro() {
    
    if(this.nombre === ""){
      this.showAllUsuario();
    }else {
      this.searchUsuarioAdmin();
    }
  }

  /*gasto 
  showAllGasto(){
    this.gastoService.getGasto().subscribe (
      gasto => this.gasto = gasto 
    ); 
  }

  searchValor(){
    this.gastoService.searchGasto(this.valor).subscribe(
      gasto => this.gasto = gasto
    )
  }*/

  //usuario
  showAllUsuario(){
    this.gastoService.getUsuario().subscribe(
      usuarios => this.usuarios = usuarios
    );
  }

  searchUsuarioAdmin(){
    this.gastoService.searchUsuario(this.nombre).subscribe(
      usuarios => this.usuarios = usuarios
    )
  }

}
