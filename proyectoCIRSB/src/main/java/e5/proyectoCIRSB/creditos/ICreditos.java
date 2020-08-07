package e5.proyectoCIRSB.creditos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ICreditos extends CrudRepository <CreditosEntity, Integer>{
	
	@Query("from CreditosEntity c where c.valor = ?1")
	public List<CreditosEntity> findByValor(Float valor); 
	
	@Query("from CreditosEntity c, TiposCreditos tc where tc.descripcion=?1 and c.idTipo=tc.idTipo")
	public List<CreditosEntity> findByTipo(String tipo);
	
	@Modifying
	@Query(value="INSERT INTO usuarioscreditos(ci_usuario, id_credito) VALUES (:ci_usuario, :id_credito)", nativeQuery = true)
	@Transactional
	public void tablaIntermedia(@Param("ci_usuario") String ci_usuario, @Param("id_credito") Integer id_credito);

}
