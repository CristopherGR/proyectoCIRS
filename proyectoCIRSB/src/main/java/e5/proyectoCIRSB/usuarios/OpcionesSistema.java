package e5.proyectoCIRSB.usuarios;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="opcionessistema")
public class OpcionesSistema implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idOpcion; 
	private String descripcion; 
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="tiposusuariosopciones", joinColumns=@JoinColumn(name="idOpcion"), inverseJoinColumns=@JoinColumn(name="idTipo"))
	private List<TiposUsuario> tiposUsuario;

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

	public List<TiposUsuario> getTiposUsuario() {
		return tiposUsuario;
	}

	public void setTiposUsuario(List<TiposUsuario> tiposUsuario) {
		this.tiposUsuario = tiposUsuario;
	}

}
