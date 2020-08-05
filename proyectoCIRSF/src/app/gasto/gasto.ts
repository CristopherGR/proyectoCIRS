import {TipoGasto} from './tipogasto'; 
import {Usuarios} from '../usuario/usuarios'; 

export class Gasto{
    idGasto: number; 
    descripcion: string; 
    valor: number;
    fecha:string; 
    idTipo: TipoGasto
    usuarios: Usuarios
}