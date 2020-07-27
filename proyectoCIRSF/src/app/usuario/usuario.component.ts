import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Usuarios } from './Usuarios'; 
import {UsuarioService} from './usuario.service';


@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  
  cedula: string;
  usuarios: Usuarios[];
  
  constructor(private usuarioService: UsuarioService,  private activedRoute: ActivatedRoute ) { }

  ngOnInit(): void {

    this.showAll();
  }

  showAll(){
    this.usuarioService.getUsuario().subscribe(
      usuarios => {console.log(usuarios);
      
      this.usuarios = usuarios  }
    );
  }


}
