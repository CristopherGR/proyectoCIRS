import { Component, OnInit } from '@angular/core';
import swal from 'sweetalert2'; 
import { Usuarios } from '../usuario/Usuarios';
import { Gasto } from './gasto';
import {UsuarioService} from '../usuario/usuario.service';
import {GastoService} from './gasto.service'; 


@Component({
  selector: 'app-gasto',
  templateUrl: './gasto.component.html',

})
export class GastoComponent implements OnInit {

 
  gasto: Gasto[];
  usuario: Usuarios[];
  valor: string; 
  nombre: string; 
  constructor(private gastoService: GastoService, private  usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.showadmin();   
  }

  filtro() {    
    if(this.valor === ""){
      this.showAllGasto();
    }else {
      this.searchValor();
    }
  }

  
  showAllGasto(){
    this.gastoService.getGasto().subscribe (
      gasto => this.gasto = gasto 
    ); 
  }

  searchValor(){
    this.gastoService.searchGasto(this.valor).subscribe(   
      
      gasto =>{
        if (gasto===[])  {
          swal.fire('¡Ups!', 'Gasto no encontrado', 'error')
          this.gasto = gasto
        }else {
          this.gasto = gasto
        }
      }   
    )
  }

  showAllAdmin(){
    this.usuarioService.searchg(this.nombre).subscribe(
      usuarios=>{
        usuarios = this.usuario;
        
        /*if (usuarios===[])  {
          swal.fire('¡Ups!', 'Gasto no encontrado', 'error')
          usuarios = this.usuario;
        }else {
          usuarios = this.usuario; 
        }*/
      }
    )
  }

  showadmin(){
    this.usuarioService.getUsuarioAdmin().subscribe(
      usuario => this.usuario = usuario  
    );
  }


}
