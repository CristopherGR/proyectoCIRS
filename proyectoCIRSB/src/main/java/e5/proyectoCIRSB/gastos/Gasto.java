package e5.proyectoCIRSB.gastos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="gastos")
public class Gasto {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private int id;
     private String motivo;
     private Float valor;
     private String numFactura;
     private String tipoGasto;
     
     
     private Date fecha;
     
    @PrePersist 
    public void prePersist() {
    	fecha = new Date(); 
    }
     
	public int getd() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public String getNumFactura() {
		return numFactura;
	}
	
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
     
     
}
