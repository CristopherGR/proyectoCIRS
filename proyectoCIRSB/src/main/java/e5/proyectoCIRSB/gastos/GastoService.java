package e5.proyectoCIRSB.gastos;

import java.util.List;

public interface GastoService {
    
	public List<Gasto> findAll();
	
	public Gasto save(Gasto gasto);
	
	public void delete(Integer id); 
	
	public Gasto findById(Integer id); 
	
}
