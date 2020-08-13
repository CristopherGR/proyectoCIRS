package e5.proyectoCIRSB.pagos;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface PagosService {
	
	public List<PagosEntity> findAll();
	
	public PagosEntity findById(Integer idPago); 
	
	public PagosEntity save(PagosEntity pago);
	
	public void delete(Integer idPago); 

	public void tablaIntermedia(@Param("id_credito") Integer id_credito, @Param("id_pago") Integer id_pago);
	
	public List<PagosEntity> findByCredito(Integer id);
	
	public List<TiposPagos> findTiposAll();

}
