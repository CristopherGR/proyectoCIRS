import { Component, OnInit } from '@angular/core';
import {Multas} from './multa'; 
import {MultaService} from './multa.service';
import {Router} from '@angular/router';
import swal from 'sweetalert2';
import { TipoMultas } from './tipomulta';

@Component({
  selector: 'app-formulta',
  templateUrl: './formulta.component.html',
})
export class FormultaComponent implements OnInit {

  public multas: Multas = new Multas();
  public title: string = "Ingresar gasto" ; 
  tipo: TipoMultas[];


  constructor(private multaService: MultaService, private router: Router) { }

  ngOnInit(): void {
    this.multaService.getTipo().subscribe(tipo => this.tipo = tipo);
  }

  public creat(){
    this.multaService.create(this.multas).subscribe(multas => { 
      this.router.navigate(['/aportes'])
      swal.fire('Ingreso de datos', `Multa creado con éxito!`, 'success')
     }
    );
  }

  compararTipo(o1: TipoMultas, o2:TipoMultas){
    return o1==null || o2==null ? false: o1.idTipo==o2.idTipo; 
  }

  

}
