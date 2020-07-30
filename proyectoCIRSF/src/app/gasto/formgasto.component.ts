import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import swal from 'sweetalert2';

import {TipoGasto} from './tipogasto';
import {Gasto} from './gasto';
import {GastoService} from './gasto.service'; 

@Component({
  selector: 'app-formgasto',
  templateUrl: './formgasto.component.html',
 
})
export class FormgastoComponent implements OnInit {

  public title: string = "Ingresar Gasto"; 
  public tipoGasto: TipoGasto[]; 
  public gasto: Gasto = new Gasto(); 

  constructor(private gastoService: GastoService,  private router: Router) { }

  ngOnInit(): void {
    this.getTipoGasto();
  }

  getTipoGasto(){
    this.gastoService.getTipoGasto().subscribe(
      tipoGasto => this.tipoGasto = tipoGasto
    );
  }

  creat(){
    this.gastoService.create(this.gasto).subscribe(gasto => {
      console.log(this.gasto)
      this.router.navigate(['/gastos'])
      swal.fire('Ingreso de gastos', `Gasto creado con éxito!`, 'success')
    }
    );
  }

  compararTipo(o1: TipoGasto, o2:TipoGasto){
    return o1==null || o2==null ? false: o1.idTipo==o2.idTipo; 
  }

}
