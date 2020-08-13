package e5.proyectoCIRSB.pagos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import e5.proyectoCIRSB.creditos.TiposCreditos;


public interface IPagos extends CrudRepository <PagosEntity, Integer>{
	
	@Query(value="SELECT * FROM pagos p, creditospagos c "
			+ "WHERE (p.id_pago = c.id_pago) AND (c.id_credito = ?1)", nativeQuery = true)
	public List<PagosEntity> findByCredito(Integer id);
	
	@Modifying
	@Query(value="INSERT INTO creditospagos(id_credito, id_pago) VALUES (:id_credito, :id_pago)", nativeQuery = true)
	@Transactional
	public void tablaIntermedia(@Param("id_credito") Integer id_credito, @Param("id_pago") Integer id_pago);
	
	@Query("from TiposPagos")
	public List<TiposPagos> findTiposAll();
	
}
