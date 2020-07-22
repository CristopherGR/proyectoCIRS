package e5.proyectoCIRSB.pagos;

import java.util.List;

public interface PagosService {
	
	public List<PagosEntity> findAll();
	
	public PagosEntity findById(Integer idPago); 
	
	public PagosEntity save(PagosEntity pago);
	
	public void delete(Integer idPago); 

}
