package e5.proyectoCIRSB.gastos;

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
public class GastoController {

	@Autowired
	//private GastoServiceIm gastoService;
	private GastoService gastoService;
	
	@GetMapping("/gastos")
	public List<Gasto> index(){
		return gastoService.findAll();
	} 
	
	@GetMapping("/gastos/{id}")
	public Gasto show(@PathVariable Integer id) {
		return gastoService.findById(id); 
	}
	
	@GetMapping("/gastos/usuario/{id}")
	public List<Gasto> showByUsuario(@PathVariable String id) {
		return gastoService.findByUsuario(id);
	}
	
	@PostMapping("/gastos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Gasto gasto, @PathVariable("id") String ci) { // request boddy porque viene en formato json dentro del cuerpo de la peticion (request)
		gastoService.save(gasto);
		gastoService.tablaIntermedia(gasto.getIdGasto(), ci);
	}
	
	@PutMapping("/gastos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Gasto update(@RequestBody Gasto gasto, @PathVariable Integer id) {
		Gasto gastoActual = gastoService.findById(id); 
		gastoActual.setDescripcion(gasto.getDescripcion());
		gastoActual.setValor(gasto.getValor());
		gastoActual.setFecha(gasto.getFecha());
		
		return gastoService.save(gastoActual); 
	}
	
	@DeleteMapping ("/gastos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		gastoService.delete(id);
	}
	
	@GetMapping("/gastos/tipos")
	public List<TiposGastos> indexTipos(){
		return gastoService.findAllTiposGasto();
	} 
	
	@GetMapping("/gastos/valorMayor/{id}")
	public List<Gasto> showValor(@PathVariable("id") Float valor) {
		return gastoService.findByValor(valor);
	}
	
}
