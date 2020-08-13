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
	
	@Query("from EstadosCreditos e where e.idEstado = 1")
	public List<EstadosCreditos> findByEstadoA(); 
	
	@Query(value="SELECT * FROM creditos c, usuarioscreditos u "
			+ "WHERE (c.id_credito = u.id_credito) AND (u.ci_usuario = ?1)", nativeQuery = true)
	public List<CreditosEntity> findByUsuario(String ci);
	
	@Modifying
	@Query(value="INSERT INTO usuarioscreditos(ci_usuario, id_credito) VALUES (:ci_usuario, :id_credito)", nativeQuery = true)
	@Transactional
	public void tablaIntermedia(@Param("ci_usuario") String ci_usuario, @Param("id_credito") Integer id_credito);

	@Query("from TiposCreditos")
	public List<TiposCreditos> Tipos();
}
