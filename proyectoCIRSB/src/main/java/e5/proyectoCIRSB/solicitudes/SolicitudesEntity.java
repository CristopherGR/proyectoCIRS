package e5.proyectoCIRSB.solicitudes;

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
import javax.persistence.PrePersist;
import javax.persistence.Table;

import e5.proyectoCIRSB.usuarios.UsuariosEntity;

@Entity
@Table (name="solicitudes")
public class SolicitudesEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSolicitud; 
	private Date fechaSolicitud; 
	private String descripcion; 
	private String estadoSolicitud;  
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuariossolicitudes", joinColumns=@JoinColumn(name="idSolicitud"), inverseJoinColumns=@JoinColumn(name="ciUsuario"))
	private List<UsuariosEntity> usuarios; 
	
	 @PrePersist 
	    public void prePersist() {
	    	fechaSolicitud = new Date(); 
	    }
	
	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

}
