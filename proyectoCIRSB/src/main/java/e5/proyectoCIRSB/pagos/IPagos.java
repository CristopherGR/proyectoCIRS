package e5.proyectoCIRSB.pagos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IPagos extends CrudRepository <PagosEntity, Integer>{
	
	@Modifying
	@Query(value="INSERT INTO creditospagos(id_credito, id_pago) VALUES (:id_credito, :id_pago)", nativeQuery = true)
	@Transactional
	public void tablaIntermedia(@Param("id_credito") Integer id_credito, @Param("id_pago") Integer id_pago);

}
