package e5.proyectoCIRSB.gastos;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastoServiceIm implements GastoService {

	@Autowired
	private IGastoM gastoModel;
	
	public List<Gasto> findAll(){
		// TODO Auto-generated method stub
		return (List<Gasto>) gastoModel.findAll();
	}

	@Override
	public Gasto save(Gasto gasto) {
		// TODO Auto-generated method stub
		return gastoModel.save(gasto);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		gastoModel.deleteById(id);
	}

	@Override
	public Gasto findById(Integer id) {
		// TODO Auto-generated method stub
		return gastoModel.findById(id).orElseThrow(null);
	}

	@Override
	public List<TiposGastos> findAllTiposGasto() {
		// TODO Auto-generated method stub
		return (List<TiposGastos>) gastoModel.findAllTiposGasto();
	}

	@Override
	public List<Gasto> findByValor(Float valor) {
		// TODO Auto-generated method stub
		return (List<Gasto>) gastoModel.findByValor(valor);
	}

	@Override
	public void tablaIntermedia(Integer id_gasto, String ci_usuario) {
		// TODO Auto-generated method stub
		gastoModel.tablaIntermedia(id_gasto, ci_usuario);
	}

	@Override
	public List<Gasto> findByUsuario(String ci) {
		// TODO Auto-generated method stub
		return (List<Gasto>) gastoModel.findByUsuario(ci);
	}

	
}
