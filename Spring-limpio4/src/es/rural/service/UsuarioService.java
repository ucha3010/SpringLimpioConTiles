package es.rural.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.rural.dao.UsuarioDao;
import es.rural.pojo.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void save(Usuario usuario) {

		usuario.setHabilitado(true);
		usuario.setFechaCreacion(new Timestamp(new Date().getTime()));
		String claveUsr = usuario.getClave();
		usuario.setClave(passwordEncoder.encode(claveUsr));

		usuarioDao.save(usuario);
	}

	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}

	public Usuario findById(int id) {
		return usuarioDao.findById(id);
	}

	public boolean saveOrUpdate(Usuario usuario) {

		if (usuario.getIdUsr() == 0) {
			save(usuario);
			return true;
		} else {
			if(!usuario.getClave().equals("")) {
				String claveUsr = usuario.getClave();
				usuario.setClave(passwordEncoder.encode(claveUsr));
			} else {
				Usuario antiguo = usuarioDao.findById(usuario.getIdUsr());
				usuario.setClave(antiguo.getClave());				
			}
			usuarioDao.update(usuario);
			return true;
		}

	}

	public void delete(int id) {
		usuarioDao.delete(id);
	}

}
