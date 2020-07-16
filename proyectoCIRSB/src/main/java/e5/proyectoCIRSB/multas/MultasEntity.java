package e5.proyectoCIRSB.multas;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="creditos")
public class MultasEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMulta;
	private int idTipo;
	private Date fechaMulta;
	private float valor;
	
	public int getIdMulta() {
		return idMulta;
	}
	public void setIdMulta(int idMulta) {
		this.idMulta = idMulta;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public Date getFechaMulta() {
		return fechaMulta;
	}
	public void setFechaMulta(Date fechaMulta) {
		this.fechaMulta = fechaMulta;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
