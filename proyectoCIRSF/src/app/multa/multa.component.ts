import { Component, OnInit } from '@angular/core';
import {Multas} from './multa'; 
import {MultaService} from './multa.service';
import {Router, ActivatedRoute} from '@angular/router';
import swal from 'sweetalert2';
import { TipoMultas } from './tipomulta';
import { Usuarios } from '../usuario/Usuarios';
import { UsuarioService } from '../usuario/usuario.service';

@Component({
  selector: 'app-multa',
  templateUrl: './multa.component.html',
  styleUrls: ['./multa.component.css']
})
export class MultaComponent implements OnInit {

  multas: Multas [];   
  title: string = "Ingresar gasto" ; 
  tipo: TipoMultas[];
  usuarios: Usuarios;

  constructor(private multaService: MultaService, private router: Router, private activated:ActivatedRoute, private usuarioService:UsuarioService) { }

  ngOnInit(): void {
     this.showAll();
     this.cargar();
  }

  showAll(){
    this.multaService.getMulta().subscribe(
     multas => {this.multas = multas}
    )
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
}
