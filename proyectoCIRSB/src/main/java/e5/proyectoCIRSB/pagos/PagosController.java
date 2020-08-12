package e5.proyectoCIRSB.pagos;

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
public class PagosController {
	
	@Autowired
	private PagosService pagosService;
	
	@GetMapping("/pagos")
	public List<PagosEntity> index(){
		return pagosService.findAll();
	}
	
	@GetMapping("/pagos/{id}")
	public PagosEntity show(@PathVariable Integer id){
		return pagosService.findById(id);
	}
	
	@GetMapping("/pagos/credito/{id}")
	public List<PagosEntity> showbyCredito(@PathVariable Integer id){
		return pagosService.findByCredito(id);
	}
	
	@PostMapping("/pagos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void nuevo(@RequestBody PagosEntity pago, @PathVariable("id") Integer idCredito) {
		pagosService.save(pago);
		pagosService.tablaIntermedia(idCredito, pago.getIdPago());
	}
	
	@PostMapping("/pagosUpdate/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public PagosEntity update(@RequestBody PagosEntity multa, @PathVariable Integer id) {
		PagosEntity pagoActual = pagosService.findById(id); 
		
		pagoActual.setFechaPago(multa.getFechaPago());
		pagoActual.setValor(multa.getValor());
		pagoActual.setTipoPago(multa.getTipoPago());
		
		return pagosService.save(pagoActual); 
	}
	
	@DeleteMapping ("/pagos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		pagosService.delete(id);
	}

	@GetMapping("/pagos/tipos")
	public List<TiposPagos> tipos(){
		return pagosService.findTiposAll();
	}
}
