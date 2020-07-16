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
	
	@PostMapping("/gastos")
	@ResponseStatus(HttpStatus.CREATED)
	public Gasto create(@RequestBody Gasto gasto) { // request boddy porque viene en formato json dentro del cuerpo de la peticion (request)
		 
		return gastoService.save(gasto);
	}
	
	@PutMapping("/gastos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Gasto update(@RequestBody Gasto gasto, @PathVariable Integer id) {
		Gasto gastoActual = gastoService.findById(id); 
		gastoActual.setDescripcion(gasto.getDescripcion());
		gastoActual.setValor(gasto.getValor());
		gastoActual.setFecha(gasto.getFecha());
		gastoActual.setTipoGasto(gasto.getTipoGasto());
		
		return gastoService.save(gastoActual); 
	}
	
	@DeleteMapping ("/gastos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		gastoService.delete(id);
	}
	
}
