package e5.proyectoCIRSB.creditos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditosSerciveIm implements CreditosService{

	@Autowired
	private ICreditos iCreditos;
	
	@Override
	public List<CreditosEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<CreditosEntity>) iCreditos.findAll();
	}

	@Override
	public CreditosEntity save(CreditosEntity credito) {
		// TODO Auto-generated method stub
		return iCreditos.save(credito);
	}

	@Override
	public void delete(Integer idCredito) {
		// TODO Auto-generated method stub
		iCreditos.deleteById(idCredito);
	}

	@Override
	public CreditosEntity findById(Integer idCredito) {
		// TODO Auto-generated method stub
		return iCreditos.findById(idCredito).orElseThrow(null);
	}

	@Override
	public List<CreditosEntity> findByValor(Float valor) {
		// TODO Auto-generated method stub
		return (List<CreditosEntity>) iCreditos.findByValor(valor);
	}

	@Override
	public List<CreditosEntity> findByTipo(Integer tipo) {
		// TODO Auto-generated method stub
		return (List<CreditosEntity>) iCreditos.findByTipo(tipo);
	}

}
