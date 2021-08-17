package web.searcher.backend.models.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.searcher.backend.models.entities.Entidad;

public interface IEntidadService {

	public void save(Entidad entidad);//guardar -> create/update 
	public Optional <Entidad> findById(Integer id);//consultar -> retrieve
	public void delete(Integer id);//Borrar -> delete
	public List<Entidad> findAll();//consultar en conjunto -> List
}
