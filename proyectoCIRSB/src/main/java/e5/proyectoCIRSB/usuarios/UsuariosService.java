package e5.proyectoCIRSB.usuarios;

import java.util.List;

public interface UsuariosService {
	
	public List<UsuariosEntity> findAll();
	
	public UsuariosEntity findById(String ciUsuario); 
	
	public UsuariosEntity save(UsuariosEntity usuario);
	
	public void delete(String ciUsuario); 
	
	public List<UsuariosEntity> findByAllCorreo(String correo);
	
	public List<UsuariosEntity> findByNombres(String nombres);
	
	public List<TiposUsuario> findAllTipoUsuarios(); 
	
	public List<UsuariosEntity> findAdmin();
	
	public List<UsuariosEntity> findAdminNom(String nombres); 

	public List<UsuariosEntity> findByEstado();
	
	public List<UsuariosEntity> findByEstadoA();
	
}
