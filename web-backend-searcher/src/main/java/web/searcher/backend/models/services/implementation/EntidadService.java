package web.searcher.backend.models.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.searcher.backend.models.entities.Entidad;
import com.searcher.backend.models.repositories.IEntidad;

import web.searcher.backend.models.services.interfaces.IEntidadService;

@Service
public class EntidadService implements IEntidadService {

	@Autowired
	private IEntidad repository;
	
	@Override
	@Transactional
	public void save(Entidad entidad) {
		// TODO Auto-generated method stub
		repository.save(entidad);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Entidad> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Entidad> findAll() {
		// TODO Auto-generated method stub
		return (List<Entidad>) repository.findAll();
	}
	
}
