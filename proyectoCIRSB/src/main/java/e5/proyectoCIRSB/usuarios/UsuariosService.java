package e5.proyectoCIRSB.usuarios;

import java.util.List;

public interface UsuariosService {
	
	public List<UsuariosEntity> findAll();
	
	public UsuariosEntity findById(String ciUsuario); 
	
	public UsuariosEntity save(UsuariosEntity usuario);
	
	public void delete(String ciUsuario); 
	
	public List<UsuariosEntity> findByAllCorreo(String correo);
	
	public List<UsuariosEntity> findByNombres(String nombres);

}
