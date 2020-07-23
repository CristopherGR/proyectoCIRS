package e5.proyectoCIRSB.gastos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IGastoM extends JpaRepository <Gasto, Integer> {

	@Query("from TiposGastos ")
	public List<TiposGastos> findAllTiposGasto(); 
	
	@Query("from Gasto g where g.valor >= ?1")
	public List<Gasto> findByValor(Float valor);
}
