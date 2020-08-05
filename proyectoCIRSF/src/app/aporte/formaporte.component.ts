import { Component, OnInit } from '@angular/core';
import {Aportes} from './aportes';
import {AporteService} from './aporte.service';
import {Router} from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-formaporte',
  templateUrl: './formaporte.component.html',
})
export class FormaporteComponent implements OnInit {

  public title: string = "Ingresar Aporte" ; 

  aporte: Aportes = new Aportes();  
 
 
   constructor(private aporteService: AporteService, private router: Router) { }
   
 
   ngOnInit(): void {
   }
 
   public creat(){
     this.aporteService.create(this.aporte).subscribe(aporte => { 
       this.router.navigate(['aportes'])
       swal.fire('Ingreso de datos', `Aporte de ${aporte.valor} creado con éxito!`, 'success')
      }
     );
   }

}
