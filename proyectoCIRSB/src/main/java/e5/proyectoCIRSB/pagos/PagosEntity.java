package e5.proyectoCIRSB.pagos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import e5.proyectoCIRSB.usuarios.UsuariosEntity;

@Entity
@Table(name="pagos")
public class PagosEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPago; 
	private Date fechaPago; 
	private float valor; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTipoPago")
	private TiposPagos tipoPago;
	
	@ManyToMany(mappedBy="pago")
	private List<UsuariosEntity> usuarios; 

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public TiposPagos getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TiposPagos tipoPago) {
		this.tipoPago = tipoPago;
	}

	public List<UsuariosEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuariosEntity> usuarios) {
		this.usuarios = usuarios;
	}
}
