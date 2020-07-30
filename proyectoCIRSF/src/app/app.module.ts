import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MenuComponent } from './menu/menu.component';
import { InicioComponent } from './inicio/inicio.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { FormusuarioComponent } from './usuario/formusuario.component';
import { CreditoComponent } from './credito/credito.component';
import { AporteComponent } from './aporte/aporte.component';
import { MultaComponent } from './multa/multa.component';
import { SolicitudComponent } from './solicitud/solicitud.component';
import { PagoComponent } from './pago/pago.component';
import { GastoComponent } from './gasto/gasto.component';
import { FormgastoComponent } from './gasto/formgasto.component';



const routes: Routes = [
  {path: '' , redirectTo: '/inicio', pathMatch: 'full'},
  {path: 'inicio', component: InicioComponent},
  {path: 'usuarios', component: UsuarioComponent},
  {path: 'usuarios/form', component: FormusuarioComponent},
  {path: 'usuarios/form/:id', component: FormusuarioComponent},
  {path: 'gastos', component:GastoComponent},
  {path: 'gasto/form', component:FormgastoComponent},
  {path: 'creditos', component: CreditoComponent}
];



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MenuComponent,
    InicioComponent,
    UsuarioComponent,
    FormusuarioComponent,
    CreditoComponent,
    AporteComponent,
    MultaComponent,
    SolicitudComponent,
    PagoComponent,
    GastoComponent,
    FormgastoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, 
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
