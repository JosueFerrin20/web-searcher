package web.searcher.backend.models.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.searcher.backend.models.entities.ofertaEmpleo;
import com.searcher.backend.models.repositories.IOfertaEmpleo;

import web.searcher.backend.models.services.interfaces.IOfertaEmpleoService;

@Service
public class OfertaEmpleoService implements IOfertaEmpleoService{
	
	@Autowired
	private IOfertaEmpleo repository;

	@Override
	@Transactional
	public void save(ofertaEmpleo oferta) {
		// TODO Auto-generated method stub
		repository.save(oferta);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<ofertaEmpleo> findById(Integer id) {
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
	public List<ofertaEmpleo> findAll() {
		// TODO Auto-generated method stub
		return (List<ofertaEmpleo>) repository.findAll();
	}
}
