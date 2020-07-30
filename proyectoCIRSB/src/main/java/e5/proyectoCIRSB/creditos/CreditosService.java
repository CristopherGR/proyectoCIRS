package e5.proyectoCIRSB.creditos;

import java.util.List;

public interface CreditosService {
	
	public List<CreditosEntity> findAll();
	
	public CreditosEntity findById(Integer idCredito); 
	
	public CreditosEntity save(CreditosEntity credito);
	
	public void delete(Integer idCredito); 
	
	public List<CreditosEntity> findByValor(Float valor); 
	
	public List<CreditosEntity> findByTipo(String tipo);
}
