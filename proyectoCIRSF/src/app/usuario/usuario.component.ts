import { Component, OnInit } from '@angular/core';
import { Usuarios } from './Usuarios'; 
import {UsuarioService} from './usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  
  nombre: string;
  usuarios: Usuarios[];
  cantidad: string; 
  
  constructor(private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
      this.showAll(); 
  }

  filtro() {
    
    if(this.nombre === ""){
      this.showAll();
    }else {
      this.searchu();
    }
  }

  showAll(){
    this.usuarioService.getUsuario().subscribe(
      usuarios => {
      console.log(usuarios);
      
      this.usuarios = usuarios  }
    );
  }

  showAdmin(){
    this.usuarioService.getUsuarioAdmin().subscribe(
      usuarios => {
        console.log(usuarios);
      
        this.usuarios = usuarios
      }
    ); 
  }

 
  searchu(){
    this.usuarioService.searchg(this.nombre).subscribe(
      respuesta => { console.log(respuesta); 
         this.usuarios=respuesta }
    )
  }

}
