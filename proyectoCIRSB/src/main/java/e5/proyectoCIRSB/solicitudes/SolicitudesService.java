package e5.proyectoCIRSB.solicitudes;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface SolicitudesService {
	
	public List<SolicitudesEntity> findAll(); 
	
    public SolicitudesEntity save(SolicitudesEntity solicitud);
	
	public void delete(Integer id); 
	
	public SolicitudesEntity findById(Integer id);
	
	public List<SolicitudesEntity> finByEstado ();

	public void tablaIntermedia(@Param("id_solicitud") Integer id_solicitud, @Param("ci_usuario") String ci_usuario);
	
	public List<SolicitudesEntity> findByUsuario(String ci);
	
}
