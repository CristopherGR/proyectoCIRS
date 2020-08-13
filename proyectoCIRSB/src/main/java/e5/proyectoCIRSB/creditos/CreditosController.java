package e5.proyectoCIRSB.creditos;

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
	
	@GetMapping("/creditos/usuario/{id}")
	public List<CreditosEntity> showByUsuario(@PathVariable String id){
		return creditosService.findByUsuario(id);
	}
	
	@GetMapping("/creditos/estadoA")
	public List<EstadosCreditos> showByEstadoA(){
		return creditosService.findByEstadoA();
	}
	
	@PostMapping("/creditos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void nuevo(@RequestBody CreditosEntity credito, @PathVariable("id") String ci) {
	creditosService.save(credito);
		creditosService.tablaIntermedia(ci, credito.getIdCredito());
	}
	
	@PostMapping("/creditosUpdate/{id}")
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
	public void delete(@PathVariable("id") Integer id) {
		creditosService.delete(id);
	}
	
	@PutMapping("/creditos/updateEstado/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public CreditosEntity updateEstado(@RequestBody EstadosCreditos estado, @PathVariable("id") Integer id) {
		
		CreditosEntity creditoActual = creditosService.findById(id);
		creditoActual.setIdEstado(estado);
		
		return creditosService.save(creditoActual);
	}
	
	@GetMapping ("/creditos/valor/{id}")
	public List<CreditosEntity> showByValor(@PathVariable("id") Float valor) {
		return creditosService.findByValor(valor);
	}
	
	@GetMapping ("/creditos/tipo/{id}")
	public List<CreditosEntity> showByTipo(@PathVariable("id") String tipo) {
		return creditosService.findByTipo(tipo);
	}
	
	@GetMapping ("/creditos/tipos")
	public List<TiposCreditos> showTipo() {
		return creditosService.Tipos();
	}
	
	
}
