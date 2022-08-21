package lt.autoservis.u5.controller;

import java.util.List;

import lt.autoservis.u5.model.entity.Autoservisai;
import lt.autoservis.u5.model.repository.AutoservisaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private AutoservisaiRepository repo;
	
	public List<Autoservisai> listAll() {
		return repo.findAll();
	}
	
	public void save(Autoservisai product) {
		repo.save(product);
	}
	
	public Autoservisai get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
