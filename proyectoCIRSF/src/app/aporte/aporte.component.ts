import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { Aportes } from './aportes';
import { AporteService } from './aporte.service';

@Component({
  selector: 'app-aporte',
  templateUrl: './aporte.component.html',
  styleUrls: ['./aporte.component.css']
})
export class AporteComponent implements OnInit {

  
  public aportes: Aportes[];
  
  
  constructor(private aporteService: AporteService, private router: Router) { }

  ngOnInit(): void {
      this.showAll(); 
  }

  showAll(){
    this.aporteService.getAllAportes().subscribe(
     aportes => {this.aportes = aportes}
    )
  }

}
