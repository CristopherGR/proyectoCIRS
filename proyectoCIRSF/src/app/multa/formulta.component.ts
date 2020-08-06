import { Component, OnInit } from '@angular/core';
import {Multas} from './multa'; 
import {MultaService} from './multa.service';
import {Router, ActivatedRoute} from '@angular/router';
import swal from 'sweetalert2';
import { TipoMultas } from './tipomulta';
import {FormGroup, FormBuilder, FormControl, Validators} from '@angular/forms';
import {debounceTime} from 'rxjs/operators';

@Component({
  selector: 'app-formulta',
  templateUrl: './formulta.component.html',
})
export class FormultaComponent implements OnInit {

  multas: Multas = new Multas();
  title: string = "Ingresar gasto" ; 
  tipo: TipoMultas[];

  form: FormGroup;
  constructor(private multaService: MultaService, private router: Router, private activated:ActivatedRoute,private formBuilder:FormBuilder) { 
    this.buildForm();
  }

  
  ngOnInit(): void {
     this.cargar();
     this.getTipo();
  }

  private buildForm(){
    this.form = this.formBuilder.group({
      valor: [0,[Validators.required,Validators.pattern(/^[0-9.]+$/) ,Validators.min(0.01)]],
      fechaM: ['', [Validators.required]]
    });

    this.form.valueChanges
    .pipe(
      debounceTime(500)
    )
    .subscribe(value =>{
      console.log(value);
    });
  }

  creat(){
    this.multaService.create(this.multas).subscribe(multas => { 
      this.router.navigate(['aporte'])
      swal.fire('Ingreso de datos', `Multa creado con éxito!`, 'success')
     }
    );
  }

  compararTipo(o1: TipoMultas, o2:TipoMultas){
    return o1==null || o2==null ? false: o1.idTipo==o2.idTipo; 
  }

  getTipo(){
    this.multaService.getTipo().subscribe(tipo => this.tipo = tipo);
  }

 
  cargar(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        this.multaService.getMultaId(id).subscribe(
          multas=>{
            this.multas = multas
          } 
        )
      }
     });
  }

  updateU(){
    this.multaService.updateMulta(this.multas).subscribe(
      multas =>{
        this.router.navigate(['aporte'])
        swal.fire('Dato actualizado', `Dato actualizadocon éxito`, 'success')
      } 
    )
  }

  

}
