package web.searcher.backend.models.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.searcher.backend.models.entities.Trabajador;
import com.searcher.backend.models.repositories.ITrabajador;

import web.searcher.backend.models.services.interfaces.ITrabajadorService;

@Service
public class TrabajadorService implements ITrabajadorService{
	
	@Autowired
	private ITrabajador repository;

	@Override
	@Transactional
	public void save(Trabajador trabajador) {
		// TODO Auto-generated method stub
		repository.save(trabajador);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Trabajador> findById(Integer id) {
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
	public List<Trabajador> findAll() {
		// TODO Auto-generated method stub
		return (List<Trabajador>) repository.findAll();
	}
}
