package e5.proyectoCIRSB.gastos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import e5.proyectoCIRSB.usuarios.UsuariosEntity;

@Entity
@Table(name="gastos")
public class Gasto implements Serializable{
  
private static final long serialVersionUID = 1L;
	
	@Id
	 private int idGasto;
     private String descripcion;
     private Float valor;
     private Date fecha;
     
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idTipo")
    private TiposGastos idTipo;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="usuariosgastos", joinColumns=@JoinColumn(name="idGasto"), inverseJoinColumns=@JoinColumn(name="ciUsuario"))
	private List<UsuariosEntity> usuarios; 
     
    @PrePersist 
    public void prePersist() {
    	fecha = new Date(); 
    }

	public int getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TiposGastos getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(TiposGastos idTipo) {
		this.idTipo = idTipo;
	}

	public List<UsuariosEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuariosEntity> usuarios) {
		this.usuarios = usuarios;
	}
    
}
