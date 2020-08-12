import {TipoCreditos} from './tipocredito'; 
import {EstadoCredito} from './estadocredito'; 

export class Creditos{
    idCredito: number; 
    idTipo: TipoCreditos; 
    idEstado: EstadoCredito;
    fechaCredito:string;
    valor:number; 
    cuotas: number; 
    cuotasPagadas: number;
    interes: number; 
    totalPagar: number; 
    descripcion: string; 
}