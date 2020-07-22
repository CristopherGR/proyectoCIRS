package e5.proyectoCIRSB.multas;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
<<<<<<< HEAD
@Table(name="tiposMultas")
public class TiposMultas implements Serializable  {
=======
@Table(name="tiposmultas")
public class TiposMultas implements Serializable{
>>>>>>> cristopher
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
<<<<<<< HEAD
	private int idTipo;
	private String descripcion;
=======
	private int idTipo; 
	private String Descripcion;
>>>>>>> cristopher
	
	
	public int getIdTipo() {
		return idTipo;
	}
<<<<<<< HEAD
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
=======
	
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	public String getDescripcion() {
		return Descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
>>>>>>> cristopher
}
