package e5.proyectoCIRSB.usuarios;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="opcinessitema")
public class OpcionesSistema implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOpcion; 
	private String descripcion; 
	
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="tiposusuariosopciones", joinColumns=@JoinColumn(name="ipOpcion"), inverseJoinColumns=@JoinColumn(name="idTipo"))
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

	public List<TiposUsuario> getTipoUsuario() {
		return tiposUsuario;
	}

	public void setTipoUsuario(List<TiposUsuario> tipoUsuario) {
		this.tiposUsuario = tipoUsuario;
	} 

}
