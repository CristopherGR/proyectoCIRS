package e5.proyectoCIRSB.solicitudes;

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
public class SolicitudesController {

	@Autowired
	public SolicitudesService solicitudesService;
	
	@GetMapping("/solicitudes")
	public List<SolicitudesEntity> index(){
		return solicitudesService.findAll();
	} 
	
	@GetMapping("/solicitudes/{id}")
	public SolicitudesEntity show(@PathVariable("id") Integer id) {
		return solicitudesService.findById(id); 
	}
	
	@GetMapping("/solicitudes/usuario/{id}")
	public List<SolicitudesEntity> showByUsuario(@PathVariable("id") String ci) {
		return solicitudesService.findByUsuario(ci);
	}
	
	@PostMapping("/solicitudes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody SolicitudesEntity solicitud, @PathVariable("id") String ci) { // request boddy porque viene en formato json 
		 solicitudesService.save(solicitud);													//dentro del cuerpo de la peticion (request)
		 solicitudesService.tablaIntermedia(solicitud.getIdSolicitud(), ci);
	}
	
	@PutMapping("/solicitudes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public SolicitudesEntity update(@RequestBody SolicitudesEntity solicitud, @PathVariable("id") Integer id) {
		SolicitudesEntity solicitudActual = solicitudesService.findById(id); 
		solicitudActual.setFechaSolicitud(solicitud.getFechaSolicitud());
		solicitudActual.setDescripcion(solicitud.getDescripcion());
		solicitudActual.setEstadoSolicitud(solicitud.getEstadoSolicitud());
		
		return solicitudesService.save(solicitudActual); 
	}
	
	@DeleteMapping ("/solicitudes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		solicitudesService.delete(id);
	}
	
	@GetMapping("/solicitudes/estado")
	public List<SolicitudesEntity> showByEstado() {
		return solicitudesService.finByEstado(); 
	}
}
