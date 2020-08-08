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
	
	@Query(value="SELECT * FROM gastos g, usuariosgastos u "
			+ "WHERE (g.id_gasto = u.id_gasto) AND (u.ci_usuario = ?1)", nativeQuery = true)
	public List<Gasto> findByUsuario(String ci);
	
	@Modifying
	@Query(value="INSERT INTO usuariosgastos(id_gasto, ci_usuario) VALUES (:id_gasto, :ci_usuario)", nativeQuery = true)
	@Transactional
	public void tablaIntermedia(@Param("id_gasto") Integer id_gasto, @Param("ci_usuario") String ci_usuario);
}
