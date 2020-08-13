package e5.proyectoCIRSB.creditos;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface CreditosService {
	
	public List<CreditosEntity> findAll();
	
	public CreditosEntity findById(Integer idCredito); 
	
	public CreditosEntity save(CreditosEntity credito);
	
	public void delete(Integer idCredito); 
	
	public List<CreditosEntity> findByValor(Float valor); 
	
	public List<CreditosEntity> findByTipo(String tipo);
	
	public void tablaIntermedia(@Param("ci_usuario") String ci_usuario, @Param("id_credito") Integer id_credito);
	
	public List<CreditosEntity> findByUsuario(String ci);
	
	public List<TiposCreditos> Tipos();
	public List<EstadosCreditos> findByEstadoA(); 

}
