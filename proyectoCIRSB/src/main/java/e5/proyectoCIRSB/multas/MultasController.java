package e5.proyectoCIRSB.multas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins= {"*"}) //se puede agregar las cabeceras de http, entre otros y los metodos 
@RestController
@RequestMapping("/api")
public class MultasController {

	@Autowired
	private MultasService multaService;
	
	@GetMapping("/multas")
	public List<MultasEntity> index(){
		return multaService.findAll();
	}
	
	@GetMapping("/multas/{id}")
	public MultasEntity show(@PathVariable Integer id){
		return multaService.findById(id);
	}
	
	@GetMapping("/multas/credito/{id}")
	public List<MultasEntity> showByCredito(@PathVariable Integer id){
		return multaService.findByCredito(id);
	}
	
	@PostMapping("/multas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void nuevo(@RequestBody MultasEntity multa, @PathVariable("id") Integer idCredito) {
		multaService.save(multa);
		multaService.tablaIntermedia(multa.getIdMulta(), idCredito);
	}
	
	@PostMapping("/multasUpdate/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public MultasEntity update(@RequestBody MultasEntity multa, @PathVariable("id")  Integer id) {
		MultasEntity multaActual = multaService.findById(id); 
		
		multaActual.setIdTipo(multa.getIdTipo());
		multaActual.setFechaMulta(multa.getFechaMulta());
		multaActual.setValor(multa.getValor());
		
		return multaService.save(multaActual); 
	}
	
	@DeleteMapping ("/multas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		multaService.delete(id);
	}
	
}
