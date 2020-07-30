import { Component, OnInit } from '@angular/core';


import {Creditos} from './credito'; 
import {CreditoService} from './credito.service'; 

@Component({
  selector: 'app-credito',
  templateUrl: './credito.component.html',
  styleUrls: ['./credito.component.css']
})
export class CreditoComponent implements OnInit {

  creditos: Creditos[]; 
  tipo: string; 
  valor: number; 

  constructor(private creditoService:CreditoService ) { }

  ngOnInit(): void {
  }

 


}
