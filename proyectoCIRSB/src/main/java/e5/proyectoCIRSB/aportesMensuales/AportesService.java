package e5.proyectoCIRSB.aportesMensuales;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface AportesService {
	
    public List<AportesEntity> findAll();
	
	public AportesEntity save(AportesEntity aporte);
	
	public void delete(Integer idAporte);
	
	public AportesEntity findById(Integer idAporte);
	
	public void tablaIntermedia(@Param("idaporte") Integer idAporte, @Param("ciusuario") String ci);

}
