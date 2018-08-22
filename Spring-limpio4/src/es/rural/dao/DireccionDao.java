package es.rural.dao;

import java.util.List;

import es.rural.pojo.Admin;
import es.rural.pojo.Direccion;

public interface DireccionDao {
	
	public void save(Direccion direccion);
	
	public List<Direccion> findAll();
	
	public Direccion findById(int id);
	
	public List<Direccion> findByCalle(String calle);
	
	public void update(Direccion direccion);
	
	public void delete(int idDir);
	
	public List<Direccion> findByAdmin(Admin admin);

}
