package web.searcher.backend.models.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.searcher.backend.models.entities.Experiencia;
import com.searcher.backend.models.repositories.IExperiencia;

import web.searcher.backend.models.services.interfaces.IExperienciaService;

@Service
public class ExperienciaService implements IExperienciaService{
	
	@Autowired
	private IExperiencia repository;
	
	@Override
	@Transactional
	public void save(Experiencia experiencia) {
		// TODO Auto-generated method stub
		repository.save(experiencia);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Experiencia> findById(Integer id) {
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
	public List<Experiencia> findAll() {
		// TODO Auto-generated method stub
		return (List<Experiencia>) repository.findAll();
	}

}
