package e5.proyectoCIRSB.multas;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface MultasService {
	
	public List<MultasEntity> findAll();
	
	public MultasEntity findById(Integer idMulta); 
	
	public MultasEntity save(MultasEntity multa);
	
	public void delete(Integer idMulta); 

	public void tablaIntermedia(@Param("id_multa") Integer id_multa, @Param("id_credito") Integer id_credito);

	public List<MultasEntity> findByCredito(Integer id);
}
