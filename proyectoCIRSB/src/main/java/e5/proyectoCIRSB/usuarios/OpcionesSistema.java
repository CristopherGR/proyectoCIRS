package e5.proyectoCIRSB.usuarios;

import java.io.Serializable;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;


public class OpcionesSistema implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idOpcion; 
	private String descripcion; 
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<TiposUsuario> tipoUsuario;

	public int getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<TiposUsuario> getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(List<TiposUsuario> tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	} 

}
