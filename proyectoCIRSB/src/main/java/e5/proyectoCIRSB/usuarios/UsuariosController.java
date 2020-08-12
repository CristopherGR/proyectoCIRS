package e5.proyectoCIRSB.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= {"*"}) //se puede agregar las cabeceras de http, entre otros y los metodos 
@RestController
@RequestMapping("/api")
public class UsuariosController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@GetMapping("/usuarios")
	public List<UsuariosEntity> index(){
		return usuariosService.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public UsuariosEntity showById(@PathVariable("id") String ci) {
		return usuariosService.findById(ci);
	}
		
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuariosEntity nuevo(@RequestBody UsuariosEntity usuario) {
		return usuariosService.save(usuario);
	}
	
	@PostMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuariosEntity update(@RequestBody UsuariosEntity usuario, @PathVariable("id") String ci) {
		UsuariosEntity usuarioActual = usuariosService.findById(ci); 
		
		usuarioActual.setIdTipoU(usuario.getIdTipoU());
		usuarioActual.setPassword(usuario.getPassword());
		usuarioActual.setNombres(usuario.getNombres());
		usuarioActual.setApellidos(usuario.getApellidos());
		usuarioActual.setCorreo(usuario.getCorreo());
		usuarioActual.setDireccion(usuario.getDireccion());
		usuarioActual.setTelefono(usuario.getTelefono());
		usuarioActual.setFechaNa(usuario.getFechaNa());
		usuarioActual.setEstado(usuario.getEstado());
		
		return usuariosService.save(usuarioActual); 
	}
	
	@PutMapping("/usuarios/updateEstado/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuariosEntity updateEstado(@PathVariable("id") String ci) {
		
		UsuariosEntity usuarioActual = usuariosService.findById(ci);
		usuarioActual.setEstado("activo");
		
		return usuariosService.save(usuarioActual); 
	}
	
	@DeleteMapping ("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String ci) {
		usuariosService.delete(ci);
	}
	
	@GetMapping("/usuarios/correo/{id}")
	public List<UsuariosEntity> showByCorreo(@PathVariable("id") String correo){
		return usuariosService.findByAllCorreo(correo);
	}
	
	@GetMapping("/usuarios/nombres/{id}")
	public List<UsuariosEntity> showByNombres(@PathVariable("id") String nombres){
		return usuariosService.findByNombres(nombres);
	}
	
	@GetMapping("/usuarios/estado")
	public List<UsuariosEntity> showByEstado(){
		return usuariosService.findByEstado();
	}
	
	@GetMapping("/usuarios/estadoA")
	public List<UsuariosEntity> showByEstadoA(){
		return usuariosService.findByEstadoA();
	}

	@GetMapping("/usuarios/tipos")
	public List<TiposUsuario> showTipoUsuario(){
		return usuariosService.findAllTipoUsuarios(); 
	}
	
	@GetMapping("/usuarios/admin")
	public List<UsuariosEntity> showAdmin(){
		return usuariosService.findAdmin(); 
	}
	
	@GetMapping("/usuarios/nomadmin/{id}")
	public List<UsuariosEntity> showAdminNom(@PathVariable("id") String nombres){
		return usuariosService.findAdminNom(nombres); 
	}		
}
