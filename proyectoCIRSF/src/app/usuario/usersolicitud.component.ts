import { Component, OnInit } from '@angular/core';
import swal from 'sweetalert2';
import { UsuarioService } from './usuario.service';
import { Usuarios } from './Usuarios';

@Component({
  selector: 'app-usersolicitud',
  templateUrl: './usersolicitud.component.html',
  
})
export class UsersolicitudComponent implements OnInit {

  public usuarios:Usuarios[];  
  
  constructor(private usuarioService: UsuarioService,) { }

  ngOnInit(): void {
    this.getSolicitud();
  }

  getSolicitud(){
    this.usuarioService.getSolicitud().subscribe(
      usuario => { this.usuarios = usuario}
    )
  }

  updateU(id){
    console.log(id); 
  }


}
