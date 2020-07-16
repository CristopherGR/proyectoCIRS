package e5.proyectoCIRSB.creditos;

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
public class CreditosController {
	
	@Autowired
	private CreditosService creditosService;
	
	@GetMapping("/creditos")
	public List<CreditosEntity> index(){
		return creditosService.findAll();
	}
	
	@GetMapping("/creditos/{id}")
	public CreditosEntity show(@PathVariable Integer id){
		return creditosService.findById(id);
	}
	
	@PostMapping("/creditos")
	@ResponseStatus(HttpStatus.CREATED)
	public CreditosEntity nuevo(@RequestBody CreditosEntity credito) {
		return creditosService.save(credito);
	}
	
	@PostMapping("/creditos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public CreditosEntity update(@RequestBody CreditosEntity credito, @PathVariable Integer id) {
		CreditosEntity creditoActual = creditosService.findById(id); 
		
		creditoActual.setIdTipo(credito.getIdTipo());
		creditoActual.setIdEstado(credito.getIdEstado());
		creditoActual.setFechaCredito(credito.getFechaCredito());
		creditoActual.setValor(credito.getValor());
		creditoActual.setCuotas(credito.getCuotas());
		creditoActual.setCuotasPagadas(credito.getCuotasPagadas());
		creditoActual.setInteres(credito.getInteres());
		creditoActual.setTotalPagar(credito.getTotalPagar());
		creditoActual.setDescripcion(credito.getDescripcion());
		
		return creditosService.save(creditoActual); 
	}
	
	@DeleteMapping ("/creditos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		creditosService.delete(id);
	}
	
}
