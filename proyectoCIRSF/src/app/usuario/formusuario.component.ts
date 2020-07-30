import { Component, OnInit } from '@angular/core';
import swal from 'sweetalert2';
import { Router } from '@angular/router';

import { UsuarioService } from './usuario.service';
import { TipoUsuario } from './tipo-usuario';
import { Usuarios } from './Usuarios';

@Component({
  selector: 'app-formusuario',
  templateUrl: './formusuario.component.html',
  
})
export class FormusuarioComponent implements OnInit {

  public title: string = "Ingresar Usuario";   
  public tipoUsuario: TipoUsuario[]; 
  public usuarios: Usuarios = new Usuarios(); 

  constructor(private usuarioService: UsuarioService, private router: Router) { }
  
  
  
  ngOnInit(): void {
    this.getTipoUsuario(); 
    
  }

  getTipoUsuario(){
    this.usuarioService.getTipoUsuario().subscribe(
       tipoUsuario => this.tipoUsuario = tipoUsuario
    );
  }

  creat(){
    this.usuarioService.create(this.usuarios).subscribe(usuarios => {
      console.log(this.usuarios)
      this.router.navigate(['/usuarios'])
      swal.fire('Ingreso de datos', `Usuario creado con éxito!`, 'success')
    }
    );
  }

  compararTipo(o1: TipoUsuario, o2:TipoUsuario){
    return o1==null || o2==null ? false: o1.idTipoU==o2.idTipoU; 
  }

}
