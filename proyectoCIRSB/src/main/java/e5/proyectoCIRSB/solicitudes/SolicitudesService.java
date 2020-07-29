package e5.proyectoCIRSB.solicitudes;

import java.util.List;

public interface SolicitudesService {
	
	public List<SolicitudesEntity> findAll(); 
	
    public SolicitudesEntity save(SolicitudesEntity solicitud);
	
	public void delete(Integer id); 
	
	public SolicitudesEntity findById(Integer id);
	
	public List<SolicitudesEntity> finByEstado ();

}
