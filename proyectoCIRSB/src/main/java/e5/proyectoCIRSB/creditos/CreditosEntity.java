package e5.proyectoCIRSB.creditos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="creditos")
public class CreditosEntity {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private int idCredito;
     private int idTipo;
     private int idEstado;
     private Date fechaCredito;
     private float valor;
     private int cuotas;
     private int cuotasPagadas;
     private float interes;
     private float totalPagar;
     private String descripcion;
	public int getIdCredito() {
		return idCredito;
	}
	public void setIdCredito(int idCredito) {
		this.idCredito = idCredito;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public Date getFechaCredito() {
		return fechaCredito;
	}
	public void setFechaCredito(Date fechaCredito) {
		this.fechaCredito = fechaCredito;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getCuotas() {
		return cuotas;
	}
	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	public int getCuotasPagadas() {
		return cuotasPagadas;
	}
	public void setCuotasPagadas(int cuotasPagadas) {
		this.cuotasPagadas = cuotasPagadas;
	}
	public float getInteres() {
		return interes;
	}
	public void setInteres(float interes) {
		this.interes = interes;
	}
	public float getTotalPagar() {
		return totalPagar;
	}
	public void setTotalPagar(float totalPagar) {
		this.totalPagar = totalPagar;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
   
}
