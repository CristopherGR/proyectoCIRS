package e5.proyectoCIRSB.aportesMensuales;

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
public class AportesController {

	@Autowired
	private AportesService aportesService;
	
	@GetMapping("/aportes")
	public List<AportesEntity> index(){
		return aportesService.findAll();
	}
	
	@GetMapping("/aportes/{id}")
	public AportesEntity show(@PathVariable Integer id) {
		return aportesService.findById(id); 
	}
	
	@GetMapping("/aportes/usuario/{id}")
	public List<AportesEntity> showByUsuario(@PathVariable String id) {
		return aportesService.findAporteByUsuario(id);
	}
	
	@PostMapping("/aportes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody AportesEntity aportes, @PathVariable("id") String ci) {
			aportesService.save(aportes);
			aportesService.tablaIntermedia(aportes.getIdAporte(), ci);
	}
	
	@PutMapping("/aportes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public AportesEntity update(@RequestBody AportesEntity aportes, @PathVariable Integer id) {
		AportesEntity aporteActual = aportesService.findById(id);
		aporteActual.setvalor(aportes.getvalor());
		
		return aportesService.save(aporteActual);
	}
	
	@DeleteMapping ("/aportes/{idAporte}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer idAporte) {
		aportesService.delete(idAporte);
	}
}
