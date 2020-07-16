package e5.proyectoCIRSB.multas;

import java.util.List;

public interface MultasService {
	
	public List<MultasEntity> findAll();
	
	public MultasEntity findById(Integer idMulta); 
	
	public MultasEntity save(MultasEntity multa);
	
	public void delete(Integer idMulta); 
	
}
