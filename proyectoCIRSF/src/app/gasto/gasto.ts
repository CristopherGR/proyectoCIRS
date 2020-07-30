import {TipoGasto} from './tipogasto'; 
import {Usuarios} from '../usuario/usuarios'; 

export class Gasto{
    idGasto: number; 
    descripcion: string; 
    valor: number; 
    idTipo: TipoGasto
    usuarios: Usuarios
}