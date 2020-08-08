package e5.proyectoCIRSB.gastos;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface GastoService {
    
	public List<Gasto> findAll();
	
	public Gasto save(Gasto gasto);
	
	public void delete(Integer id); 
	
	public Gasto findById(Integer id); 
	
	public List<TiposGastos> findAllTiposGasto();
	
	public List<Gasto> findByValor(Float valor);
	
	public void tablaIntermedia(@Param("id_gasto") Integer id_gasto, @Param("ci_usuario") String ci_usuario);
	
	public List<Gasto> findByUsuario(String ci);

}
