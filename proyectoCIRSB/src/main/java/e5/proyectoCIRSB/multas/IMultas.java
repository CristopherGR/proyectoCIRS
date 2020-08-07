package e5.proyectoCIRSB.multas;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IMultas extends CrudRepository <MultasEntity, Integer> {

	@Modifying
	@Query(value="INSERT INTO creditosmultas(id_multa, id_credito) VALUES (:id_multa, :id_credito)", nativeQuery = true)
	@Transactional
	public void tablaIntermedia(@Param("id_multa") Integer id_multa, @Param("id_credito") Integer id_credito);
}
