package e5.proyectoCIRSB.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagosServiceIm implements PagosService {

	@Autowired
	private IPagos iPagos;
	
	@Override
	public List<PagosEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<PagosEntity>) iPagos.findAll();
	}

	@Override
	public PagosEntity findById(Integer idPago) {
		// TODO Auto-generated method stub
		return iPagos.findById(idPago).orElseThrow(null);
	}

	@Override
	public PagosEntity save(PagosEntity pago) {
		// TODO Auto-generated method stub
		return iPagos.save(pago);
	}

	@Override
	public void delete(Integer idPago) {
		// TODO Auto-generated method stub
		iPagos.deleteById(idPago);
	}

	@Override
	public void tablaIntermedia(Integer id_credito, Integer id_pago) {
		// TODO Auto-generated method stub
		iPagos.tablaIntermedia(id_credito, id_pago);
	}

	@Override
	public List<PagosEntity> findByCredito(Integer id) {
		// TODO Auto-generated method stub
		return (List<PagosEntity>) iPagos.findByCredito(id);
	}

	@Override
	public List<TiposPagos> findTiposAll() {
		// TODO Auto-generated method stub
		return (List<TiposPagos>) iPagos.findTiposAll();
	}

}
