package e5.proyectoCIRSB.usuarios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


@Transactional
public interface IUsuarios extends CrudRepository <UsuariosEntity, String> {
	
	@Query("from UsuariosEntity u where u.correo = ?1 ")
	public List<UsuariosEntity> findByAllCorreo(String correo);
	
	@Query("from UsuariosEntity u where u.nombres = ?1 ")
	public List<UsuariosEntity> findByNombres(String nombres);
	
	@Query("from UsuariosEntity u where u.estado = 'pendiente' ")
	public List<UsuariosEntity> findByEstado();
	
	@Query("from UsuariosEntity u where u.estado = 'activo' ")
	public List<UsuariosEntity> findByEstadoA();

	@Query("from TiposUsuario")
	public List<TiposUsuario> findAllTipoGastos(); 
	
	@Query("from UsuariosEntity u where u.idTipoU = 1")
	public List<UsuariosEntity> findAdmin(); 
	
	@Query("from UsuariosEntity u where  u.nombres =?1 and u.idTipoU = 1")
	public List<UsuariosEntity> findAdminNom(String nombres); 
	
}
