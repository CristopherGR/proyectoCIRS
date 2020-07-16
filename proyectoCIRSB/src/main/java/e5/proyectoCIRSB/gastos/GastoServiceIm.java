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

	
}
