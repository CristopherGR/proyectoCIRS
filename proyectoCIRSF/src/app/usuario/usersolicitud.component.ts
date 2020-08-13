import { Component, OnInit } from '@angular/core';
import swal from 'sweetalert2';
import { Router} from '@angular/router';

import { UsuarioService } from './usuario.service';
import { Usuarios } from './Usuarios';

@Component({
  selector: 'app-usersolicitud',
  templateUrl: './usersolicitud.component.html',
  
})
export class UsersolicitudComponent implements OnInit {

  public usuarios:Usuarios[];  
  
  constructor(private usuarioService: UsuarioService,private router: Router) { }

  ngOnInit(): void {
    this.getSolicitud();
  }

  getSolicitud(){
    this.usuarioService.getSolicitud().subscribe(
      usuario => { this.usuarios = usuario}
    )
  }

  updateU(id){
    this.usuarioService.estado(this.usuarios, id).subscribe( () =>{
      swal.fire('Socio Activo', `Socio activado con éxito`, 'success');
      this.router.navigate(['/usuarios'])
    }
    )
  }


}
