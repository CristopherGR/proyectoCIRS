import { Component, OnInit } from '@angular/core';
import {Aportes} from './aportes';
import {AporteService} from './aporte.service';
import {Router, ActivatedRoute} from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-formaporte',
  templateUrl: './formaporte.component.html',
})
export class FormaporteComponent implements OnInit {

  public title: string = "Ingresar Aporte" ; 

  aporte: Aportes = new Aportes();  
 
 
   constructor(private aporteService: AporteService, private router: Router, private activated:ActivatedRoute) { }
   
 
   ngOnInit(): void {
     this.cargar()
   }
 
   public creat(){
     this.aporteService.create(this.aporte).subscribe(aporte => { 
       this.router.navigate(['aportes'])
       swal.fire('Ingreso de datos', `Aporte de ${aporte.valor} creado con éxito!`, 'success')
      }
     );
   }

   public cargar(){
    this.activated.params.subscribe(idaporte => {
      let id = idaporte['id']
      if(id){
        this.aporteService.getAporteId(id).subscribe(
          (aporte) => this.aporte = aporte
        )
      }
    });
  }

  public updateU(){
    this.aporteService.updateAporte(this.aporte).subscribe(
      aporte =>{
        this.router.navigate(['/aporte'])
        swal.fire('Dato actualizado', `Dato actualizado ${aporte.idAporte} con éxito`, 'success')
      } 
    )
  }

}
