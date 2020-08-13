import { Component, OnInit } from '@angular/core';


import {Creditos} from './credito'; 
import {CreditoService} from './credito.service'; 
import swal from 'sweetalert2';
import { ActivatedRoute } from '@angular/router';
import { TipoCreditos } from './tipocredito';
import {FormGroup, FormBuilder, FormControl, Validators} from '@angular/forms';
import {debounceTime} from 'rxjs/operators';

@Component({
  selector: 'app-credito',
  templateUrl: './credito.component.html',
  styleUrls: ['./credito.component.css']
})
export class CreditoComponent implements OnInit {

  creditos: Creditos[]; 
  tipo: string; 
  valor: string; 
  credito: Creditos = new Creditos();
  tipocredito: TipoCreditos[];
  n: boolean = true; 
  form: FormGroup;

  constructor(private creditoService:CreditoService, private activated:ActivatedRoute,private formBuilder:FormBuilder ) {
    this.buildForm();
   }

  ngOnInit(): void {
    this.showAllCreditos();
    this.showTipo();
    this.creat();
  }

  private buildForm(){
    this.form = this.formBuilder.group({
      motivo:['', [Validators.required]],
      valor: [0,[Validators.required,Validators.pattern(/^[0-9.]+$/) ,Validators.min(0.01)]],
      fechaCredito: ['', [Validators.required]],
      cuotas: [0,[Validators.required,Validators.pattern(/^[0-9.]+$/) ,Validators.min(1)]],
      tipoCredito:['', [Validators.required]]
    });

    this.form.valueChanges
    .pipe(
      debounceTime(500)
    )
    .subscribe(value =>{
      console.log(value);
    });
  }
  
  filtro() {
    
    if(this.valor === ""){
      this.showAllCreditos();
    }else {
      this.searchUsuarioAdmin();
    }
  }


  showAllCreditos(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        console.log(id)
        this.creditoService.getCreditoUser(id).subscribe(credito => { this.creditos = credito})
      }
     });   
  }

  searchUsuarioAdmin(){
    let valors = Number(this.valor)

    this.creditoService.searchCreditoValor(valors).subscribe(
      creditos => {
        if(creditos === []){
          console.log(creditos)
          swal.fire('Aviso', 'No se encontro ningun credito', 'error')
          this.creditos = creditos
        }
        else{
          this.creditos = creditos
        }
      }
    )
  }

  showTipo(){
     this.creditoService.getTipoCredito().subscribe(
       tipoCredito => {
         console.log(tipoCredito);
         this.tipocredito = tipoCredito
        }
     ) 
  }


  creat(){
    let cont = 0;
    for(var i = 0; i < this.creditos.length; i++)
    { 
      let credito = this.creditos[i]
      if (credito.idEstado.descripcion === "activo")
       cont++;
    }

    if (cont>0){
      this.n = true;
      swal.fire('No esta disponible','Creditos Activos','error')
    }else{
      this.n = false;
    }
  }

  crear(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        console.log(id)
        this.credito.interes = this.interes();
        this.credito.totalPagar = this.total();  
        this.creditoService.create(this.credito, id).subscribe( 
          nuevo => {swal.fire('Creado con éxito','Creditos creado','success')})
      }
     });
  }
 

  interes(): number {
      return this.credito.valor*0.015;

  }

  total(): number{
      return (this.credito.valor+this.credito.interes) 
  }

  estado(): number{
    return 1
  }

}
  
  


