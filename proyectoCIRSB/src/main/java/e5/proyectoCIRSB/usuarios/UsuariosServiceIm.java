package e5.proyectoCIRSB.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceIm implements UsuariosService{

	@Autowired
	private IUsuarios iUsuarios;

	@Override
	public List<UsuariosEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<UsuariosEntity>) iUsuarios.findAll();
	}

	@Override
	public UsuariosEntity findById(String ciUsuario) {
		// TODO Auto-generated method stub
		return iUsuarios.findById(ciUsuario).orElseThrow(null);
	}

	@Override
	public UsuariosEntity save(UsuariosEntity usuario) {
		// TODO Auto-generated method stub
		return iUsuarios.save(usuario);
	}

	@Override
	public void delete(String ciUsuario) {
		// TODO Auto-generated method stub
		iUsuarios.deleteById(ciUsuario);
	}

	@Override
	public List<UsuariosEntity> findByAllCorreo(String correo) {
		// TODO Auto-generated method stub
		return (List<UsuariosEntity>) iUsuarios.findByAllCorreo(correo);
	}

	@Override
	public List<UsuariosEntity> findByNombres(String nombres) {
		// TODO Auto-generated method stub
		return (List<UsuariosEntity>) iUsuarios.findByNombres(nombres);
	}

	@Override
	public List<TiposUsuario> findAllTipoUsuarios() {
		// TODO Auto-generated method stub
		return (List<TiposUsuario>) iUsuarios.findAllTipoGastos();
	}

	@Override
	public List<UsuariosEntity> findAdmin(){
		// TODO Auto-generated method stub
		return (List<UsuariosEntity>) iUsuarios.findAdmin();
	}

	@Override
	public List<UsuariosEntity> findAdminNom(String nombres) {
		// TODO Auto-generated method stub
		return (List<UsuariosEntity>) iUsuarios.findAdminNom(nombres);
	}
	public List<UsuariosEntity> findByEstado() {
		// TODO Auto-generated method stub
		return (List<UsuariosEntity>) iUsuarios.findByEstado();
	}

	@Override
	public List<UsuariosEntity> findByEstadoA() {
		// TODO Auto-generated method stub
		return (List<UsuariosEntity>) iUsuarios.findByEstadoA();
	}

}
