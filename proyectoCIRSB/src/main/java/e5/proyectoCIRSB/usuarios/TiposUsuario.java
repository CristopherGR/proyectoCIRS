package e5.proyectoCIRSB.usuarios;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tiposusuario")
public class TiposUsuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoU; 
	private String descripcion;
	
		
	public int getIdTipo() {
		return idTipoU;
	}
	public void setIdTipo(int idTipoU) {
		this.idTipoU = idTipoU;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
