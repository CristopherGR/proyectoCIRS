import {TipoCreditos} from './tipocredito'; 

export class Creditos{
    idCredito: number; 
    idTipo: TipoCreditos; 
    
    cuotas: number; 
    cuotasPagadas: number;
    interes: number; 
    totalPagar: number; 
    descripcion: string; 
}