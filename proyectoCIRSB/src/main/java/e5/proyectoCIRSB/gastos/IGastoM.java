package e5.proyectoCIRSB.gastos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IGastoM extends CrudRepository <Gasto, Integer> {

	@Query(" from TiposGastos ")
	public List<TiposGastos> findAllGasto(); 
}
