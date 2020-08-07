package e5.proyectoCIRSB.gastos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IGastoM extends JpaRepository <Gasto, Integer> {

	@Query("from TiposGastos ")
	public List<TiposGastos> findAllTiposGasto(); 
	
	@Query("from Gasto g where g.valor >= ?1")
	public List<Gasto> findByValor(Float valor);
	
	@Modifying
	@Query(value="INSERT INTO usuariosgastos(id_gasto, ci_usuario) VALUES (:id_gasto, :ci_usuario)", nativeQuery = true)
	@Transactional
	public void tablaIntermedia(@Param("id_gasto") Integer id_gasto, @Param("ci_usuario") String ci_usuario);
}
