package e5.proyectoCIRSB.aportesMensuales;

import java.util.List;

public interface AportesService {
	
    public List<AportesEntity> findAll();
	
	public AportesEntity save(AportesEntity aporte);
	
	public void delete(Integer idAporte);
	
	public AportesEntity findById(Integer idAporte);

}
