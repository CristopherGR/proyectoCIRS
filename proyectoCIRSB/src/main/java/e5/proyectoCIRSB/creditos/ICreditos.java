package e5.proyectoCIRSB.creditos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ICreditos extends CrudRepository <CreditosEntity, Integer>{
	
	@Query("from CreditosEntity c where c.valor = ?1")
	public List<CreditosEntity> findByValor(Float valor); 
	
	@Query("from Gasto g where g.idTipo = ?1")
	public List<CreditosEntity> findByTipo(Integer tipo);

}
