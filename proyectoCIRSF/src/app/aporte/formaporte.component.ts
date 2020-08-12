import { Component, OnInit } from '@angular/core';
import {Aportes} from './aportes';
import {AporteService} from './aporte.service';
import {Router, ActivatedRoute} from '@angular/router';
import swal from 'sweetalert2';
import {FormGroup, FormBuilder, FormControl, Validators} from '@angular/forms';
import {debounceTime} from 'rxjs/operators';


@Component({
  selector: 'app-formaporte',
  templateUrl: './formaporte.component.html',
})
export class FormaporteComponent implements OnInit {

  public title: string = "Ingresar Aporte" ; 

  aporte: Aportes = new Aportes();  
 
  form: FormGroup;

   constructor(private aporteService: AporteService, private router: Router, private activated:ActivatedRoute,private formBuilder:FormBuilder) {
    this.buildForm();
    }
   
   ngOnInit(): void {
     this.cargar()
   }

   private buildForm(){
    this.form = this.formBuilder.group({
      valor: [0,[Validators.required,Validators.pattern(/^[0-9.]+$/) ,Validators.min(0.01)]],
      fechaAp: ['', [Validators.required]]
    });

    this.form.valueChanges
    .pipe(
      debounceTime(500)
    )
    .subscribe(value =>{
      console.log(value);
    });
  }
 
  /* public creat(){
  
     this.aporteService.create(this.aporte).subscribe(aporte => { 
      console.log('crear')
       this.router.navigate(['aportes'])
       swal.fire('Ingreso de datos', `Aporte de ${aporte.valor} creado con éxito!`, 'success')
      }
     );
   }*/

   cargar(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        this.aporteService.getAporteId(id).subscribe(
          aporte=>{
            console.log('cargar');
            this.aporte = aporte
          } 
        )
      }
     });
    }
    
  updateU(){
    this.aporteService.updateAporte(this.aporte).subscribe(
      aporte =>{
        this.router.navigate(['aporte'])
        swal.fire('Dato actualizado', `Dato actualizado ${aporte.idAporte} con éxito`, 'success')
      } 
    )
  }

}
