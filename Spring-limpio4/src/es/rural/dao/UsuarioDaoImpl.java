package es.rural.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.rural.pojo.Usuario;

@SuppressWarnings("unchecked")
@Transactional
@Repository
public class UsuarioDaoImpl implements UsuarioDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Usuario usuarios) {
		getSession().save(usuarios);
	}

	@Override
	public List<Usuario> findAll() {
		Query query = getSession().createQuery("from Usuario"); //usando HQL
		return query.list();
	}

	@Override
	public Usuario findById(int id) {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("idUsr", id));
		Usuario usuarios = (Usuario) criteria.uniqueResult();
		return usuarios;
	}

	@Override
	public List<Usuario> findByNombre(String nombre) {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.like("usuario", "%" + nombre + "%"));
		return criteria.list();
	}

	@Override
	public Usuario findByUsername(String nombre) {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("usuario", nombre));
		return (Usuario) criteria.uniqueResult();
	}

	@Override
	public void update(Usuario usuarios) {
		getSession().update(usuarios);
	}

	@Override
	public void delete(int idAd) {
		Usuario usuarios = findById(idAd);
		getSession().delete(usuarios);
	}
	
	

}
