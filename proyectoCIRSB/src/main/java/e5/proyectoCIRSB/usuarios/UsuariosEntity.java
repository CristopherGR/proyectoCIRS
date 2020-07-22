package e5.proyectoCIRSB.usuarios;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import e5.proyectoCIRSB.creditos.CreditosEntity;

@Entity
@Table(name="usuariossistema")
public class UsuariosEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String ciUsuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTipoU")
	private TiposUsuario idTipoU;
	
	@Column(length=60)
	private String password;
	private String nombres; 
	private String apellidos; 
	private String correo;
	private String direccion;
	private String telefono;
	private Date fechaNa;
	private String estado;
	
	@ManyToMany
	@JoinTable(name="usuarioscreditos", joinColumns=@JoinColumn(name="ciUsuario"), inverseJoinColumns=@JoinColumn(name="idCredito"))
	private List<CreditosEntity> credito;

	public String getCiUsuario() {
		return ciUsuario;
	}
	
	public void setCiUsuario(String ciUsuario) {
		this.ciUsuario = ciUsuario;
	}
	
	public TiposUsuario getIdTipoU() {
		return idTipoU;
	}

	public void setIdTipoU(TiposUsuario idTipoU) {
		this.idTipoU = idTipoU;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Date getFechaNa() {
		return fechaNa;
	}
	
	public void setFechaNa(Date fechaNa) {
		this.fechaNa = fechaNa;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
