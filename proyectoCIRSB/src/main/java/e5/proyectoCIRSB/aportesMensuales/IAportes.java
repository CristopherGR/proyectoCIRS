package e5.proyectoCIRSB.aportesMensuales;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IAportes extends CrudRepository <AportesEntity, Integer> {
	
	@Query(value="SELECT * FROM aportesmensuales a, usuariosaportes u "
			+ "WHERE (a.id_aporte = u.id_aporte) AND (u.ci_usuario = ?1)", nativeQuery = true)
	public List<AportesEntity> findAporteByUsuario(String ci);

	@Modifying
	@Query(value="INSERT INTO usuariosaportes(id_aporte, ci_usuario) VALUES (:idaporte, :ciusuario)", nativeQuery = true)
	@Transactional
	public void tablaIntermedia(@Param("idaporte") Integer idAporte, @Param("ciusuario") String ci);
}
