package e5.proyectoCIRSB.creditos;

import java.io.Serializable;
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

import e5.proyectoCIRSB.pagos.PagosEntity;


@Entity
@Table(name="creditos")
public class CreditosEntity implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCredito;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTipo")	
    private TiposCreditos idTipo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idEstado")
    private EstadosCreditos idEstado;
	
    private Date fechaCredito;
    private float valor;
    private int cuotas;
    private int cuotasPagadas;
    private float interes;
    private float totalPagar;
    private String descripcion;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="creditospagos", joinColumns=@JoinColumn(name="idCredito"), inverseJoinColumns=@JoinColumn(name="idPago"))
	private List<PagosEntity> pagos;
	

	public int getIdCredito() {
		return idCredito;
	}

	public void setIdCredito(int idCredito) {
		this.idCredito = idCredito;
	}

	public TiposCreditos getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(TiposCreditos idTipo) {
		this.idTipo = idTipo;
	}

	public EstadosCreditos getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(EstadosCreditos idEstado) {
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
