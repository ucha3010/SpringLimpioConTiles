package es.rural.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.rural.dao.UsuarioDao;
import es.rural.pojo.Usuario;

@Service("customDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioDao usuariosDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//tengo que crear un usuario de este objeto org.springframework.security.core.userdetails.User.class
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Usuario usuario = usuariosDao.findByUsername(username);
		if(usuario != null) {
			authorities.add(new SimpleGrantedAuthority(usuario.getPermiso()));
			User user = new User(usuario.getUsuario(), usuario.getClave(), authorities);
			return user;
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
	}

}
