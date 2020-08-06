import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Aportes } from './aportes';
import { AporteService } from './aporte.service';
import { UsuarioService } from '../usuario/usuario.service';
import { Usuarios } from '../usuario/usuarios';

@Component({
  selector: 'app-aporteus',
  templateUrl: './aporteus.component.html'
})
export class AporteusComponent implements OnInit {

  public aportes: Aportes[];
  public usuarios: Usuarios;
  public title: "Aporte de cada usuario"
  constructor(private aporteService: AporteService, private activated: ActivatedRoute , private usuarioService:UsuarioService) { }

  ngOnInit(): void {
      this.cargar(); 
      this.showAll();
  }

  showAll(){
    this.aporteService.getAllAportes().subscribe(
     aportes => {this.aportes = aportes}
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
