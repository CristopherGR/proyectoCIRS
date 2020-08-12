import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import swal from 'sweetalert2';
import { Aportes } from './aportes';
import { AporteService } from './aporte.service';
import { UsuarioService } from '../usuario/usuario.service';
import { Usuarios } from '../usuario/usuarios';
import {FormGroup, FormBuilder, FormControl, Validators} from '@angular/forms';
import {debounceTime} from 'rxjs/operators';

@Component({
  selector: 'app-aporteus',
  templateUrl: './aporteus.component.html'
})

export class AporteusComponent implements OnInit {

  public aportes: Aportes[];
  public aporte: Aportes = new Aportes(); 
  public usuarios: Usuarios;
  public title: "Aporte de cada usuario"; 
  form: FormGroup;
  
  constructor(private aporteService: AporteService, private activated: ActivatedRoute , private usuarioService:UsuarioService, private router: Router, private formBuilder:FormBuilder) { }

  ngOnInit(): void {
      this.cargar(); 
      this.aporteUsuario();
      this.buildForm();
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
 



  cargar(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        this.usuarioService.getUsuarioId(id).subscribe(
          usuarios=>{
            this.usuarios = usuarios
          } 
        )
      }
     });
  }


  aporteUsuario(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        this.aporteService.getAporteUsuario(id).subscribe(
          aportes=>{
            this.aportes = aportes
          } 
        )
      }
     });
  }
  

  public creat(){
    this.activated.params.subscribe(parametros => {
      let id = parametros['id']
      if(id){
        this.aporteService.create(this.aporte, id).subscribe(aporte => { 
          console.log('crear')
            swal.fire('Ingreso de datos', `Aporte de creado con éxito!`, 'success')
          }
         );
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
