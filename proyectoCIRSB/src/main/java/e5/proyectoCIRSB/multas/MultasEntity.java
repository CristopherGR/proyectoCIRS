package e5.proyectoCIRSB.multas;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import e5.proyectoCIRSB.creditos.CreditosEntity;

@Entity
@Table(name="multas")
public class MultasEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMulta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTipo")
	private TiposMultas idTipo;
	
	private Date fechaMulta;
	private float valor;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="creditosmultas", joinColumns=@JoinColumn(name="idMulta"), inverseJoinColumns=@JoinColumn(name="idCredito"))
	private List<CreditosEntity> credito;
	
	
	public int getIdMulta() {
		return idMulta;
	}
	public void setIdMulta(int idMulta) {
		this.idMulta = idMulta;
	}

	public TiposMultas getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(TiposMultas idTipo) {
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
