package es.rural.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rural.dao.DireccionDao;
import es.rural.pojo.Admin;
import es.rural.pojo.Direccion;

@Service
public class DireccionService {

	@Autowired
	private DireccionDao direccionDao;

	public void save(Admin admin, Direccion direccion) {

		direccion.setAdmin(admin);
		direccionDao.save(direccion);
	}

	public List<Direccion> findAll() {
		return direccionDao.findAll();
	}

	public Direccion findById(int id) {
		return direccionDao.findById(id);
	}

	public void saveOrUpdate(Admin admin, Direccion direccion) {

		if (direccion.getIdDir() == 0) {
			save(admin, direccion);
		} else {
			direccion.setAdmin(admin);
			direccionDao.update(direccion);
		}

	}

	public void delete(int id) {
		direccionDao.delete(id);
	}
	
	public List<Direccion> findByAdmin(Admin admin) {
		return direccionDao.findByAdmin(admin);
	}

}
