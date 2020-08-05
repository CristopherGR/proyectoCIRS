import { Component, OnInit } from '@angular/core';
import {Multas} from './multa'; 
import {MultaService} from './multa.service';
import {Router} from '@angular/router';
import swal from 'sweetalert2';
import { TipoMultas } from './tipomulta';

@Component({
  selector: 'app-multa',
  templateUrl: './multa.component.html',
  styleUrls: ['./multa.component.css']
})
export class MultaComponent implements OnInit {

  public multas: Multas [];   
  public title: string = "Ingresar gasto" ; 
  tipo: TipoMultas[];


  constructor(private multaService: MultaService, private router: Router) { }

  ngOnInit(): void {
     this.show();
  }

  public show(){
    this.multaService.getMutla().subscribe(
      multas => this.multas= multas
    )
  }



}
