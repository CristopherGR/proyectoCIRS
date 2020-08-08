package e5.proyectoCIRSB.solicitudes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudesServiceIm implements SolicitudesService{

	@Autowired
	private ISolicitudes iSolicitudes;
	
	@Override
	public List<SolicitudesEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<SolicitudesEntity>) iSolicitudes.findAll();
	}

	@Override
	public SolicitudesEntity save(SolicitudesEntity solicitud) {
		// TODO Auto-generated method stub
		return iSolicitudes.save(solicitud);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		iSolicitudes.deleteById(id);
	}

	@Override
	public SolicitudesEntity findById(Integer id) {
		return iSolicitudes.findById(id).orElseThrow(null);
	}

	@Override
	public List<SolicitudesEntity> finByEstado() {
		// TODO Auto-generated method stub
		return (List<SolicitudesEntity>) iSolicitudes.finByEstado();
	}

	@Override
	public void tablaIntermedia(Integer id_solicitud, String ci_usuario) {
		// TODO Auto-generated method stub
		iSolicitudes.tablaIntermedia(id_solicitud, ci_usuario);
	}

	@Override
	public List<SolicitudesEntity> findByUsuario(String ci) {
		// TODO Auto-generated method stub
		return (List<SolicitudesEntity>) iSolicitudes.findByUsuario(ci);
	}

}
