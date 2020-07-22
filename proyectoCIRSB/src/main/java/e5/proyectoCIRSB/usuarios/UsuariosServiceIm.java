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
		return null;
	}

	@Override
	public UsuariosEntity save(UsuariosEntity usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String ciUsuario) {
		// TODO Auto-generated method stub
		
	}


	
}
