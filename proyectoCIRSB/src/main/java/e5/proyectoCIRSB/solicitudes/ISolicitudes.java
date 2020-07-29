package e5.proyectoCIRSB.solicitudes;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ISolicitudes extends CrudRepository <SolicitudesEntity, Integer>{
	
	@Query("from SolicitudesEntity s where s.estadoSolicitud = 'pendiente'")
	public List<SolicitudesEntity> finByEstado ();

}
