package e5.proyectoCIRSB.aportesMensuales;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IAportes extends CrudRepository <AportesEntity, Integer> {

	@Modifying
	@Query(value="INSERT INTO usuariosaportes(id_aporte, ci_usuario) VALUES (:idaporte, :ciusuario)", nativeQuery = true)
	//public void tablaIntermedia(String ci, Integer idAporte);
	@Transactional
	public void tablaIntermedia(@Param("idaporte") Integer idAporte, @Param("ciusuario") String ci);
}
