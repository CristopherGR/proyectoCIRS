import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { Aportes } from './aportes';
import { AporteService } from './aporte.service';
import { UsuarioService } from '../usuario/usuario.service';
import { Usuarios } from '../usuario/usuarios';
 
@Component({
  selector: 'app-aporte',
  templateUrl: './aporte.component.html'
})
export class AporteComponent implements OnInit {

  
  public aportes: Aportes[];
  public usuarios: Usuarios[];
  
  constructor(private aporteService: AporteService, private usuarioService:UsuarioService) { }

  ngOnInit(): void {
      this.showUsuario(); 
  }

  showAll(){
    this.aporteService.getAllAportes().subscribe(
     aportes => {this.aportes = aportes}
    )
  }

  showUsuario(){
    this.usuarioService.getUsuario().subscribe(
      usuarios=> {this.usuarios = usuarios}
    )
  }

  
  

}
