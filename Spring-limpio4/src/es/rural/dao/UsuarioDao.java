package es.rural.dao;

import java.util.List;

import es.rural.pojo.Usuario;

public interface UsuarioDao {
	
	public void save(Usuario usuarios);
	
	public List<Usuario> findAll();
	
	public Usuario findById(int id);
	
	public List<Usuario> findByNombre(String nombre);
	
	public void update(Usuario usuarios);
	
	public void delete(int idUsr);

	Usuario findByUsername(String nombre);
	

}
