package e5.proyectoCIRSB.multas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultasServiceIm implements MultasService {

	@Autowired
	private IMultas iMultas;
	
	@Override
	public List<MultasEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<MultasEntity>) iMultas.findAll();
	}

	@Override
	public MultasEntity findById(Integer idMulta) {
		// TODO Auto-generated method stub
		return iMultas.findById(idMulta).orElseThrow(null);
	}

	@Override
	public MultasEntity save(MultasEntity multa) {
		// TODO Auto-generated method stub
		return iMultas.save(multa);
	}

	@Override
	public void delete(Integer idMulta) {
		// TODO Auto-generated method stub
		iMultas.deleteById(idMulta);
	}

	@Override
	public void tablaIntermedia(Integer id_multa, Integer id_credito) {
		// TODO Auto-generated method stub
		iMultas.tablaIntermedia(id_multa, id_credito);
	}

	@Override
	public List<MultasEntity> findByCredito(Integer id) {
		// TODO Auto-generated method stub
		return (List<MultasEntity>) iMultas.findByCredito(id);
	}

}
