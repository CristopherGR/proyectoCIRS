import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2';

import {TipoGasto} from './tipogasto';
import {Gasto} from './gasto';
import {GastoService} from './gasto.service'; 
import { Usuarios } from '../usuario/Usuarios';
import { UsuarioService } from '../usuario/usuario.service';

@Component({
  selector: 'app-formgasto',
  templateUrl: './formgasto.component.html',
 
})

export class FormgastoComponent implements OnInit {

  title: string = "INGRESAR GASTOS"; 
  tipoGasto: TipoGasto[]; 
  usuarios: Usuarios;
  nombre: string; 
  gasto: Gasto = new Gasto(); 
  gastos: Gasto[];

  constructor(private gastoService: GastoService,  private router: Router,private activated: ActivatedRoute, private usuarioService:UsuarioService) { }

  ngOnInit(): void {
    this.cargar();
    this.getTipoGasto();
    this.gastoUsuario();
  }


  filtro() {
      
  }

  //obtener el tipo del gasto
  getTipoGasto(){
    this.gastoService.getTipoGasto().subscribe(
      tipoGasto => this.tipoGasto = tipoGasto
    );
  }

  //crear un gasto
  

  //comparar si el tipo de gasto es el mismo
  compararTipo(o1: TipoGasto, o2:TipoGasto){
    return o1==null || o2==null ? false: o1.idTipo==o2.idTipo; 
  }

  gastoUsuario(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        this.gastoService.getGastoUsuario(id).subscribe(
          gastos=>{
            this.gastos=gastos
            console.log(gastos);
          } 
        )
      }
     });
  }

  cargar(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        this.usuarioService.getUsuarioId(id).subscribe(
          usuarios=>{
            this.usuarios = usuarios
          } 
        )
      }
     });
  }


  creat(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        this.gastoService.create(this.gasto, id).subscribe(aporte => { 
          console.log('crear')
            swal.fire('Ingreso de datos', `Aporte de creado con éxito!`, 'success')
          }
         );
      }
    });   
  }



}
