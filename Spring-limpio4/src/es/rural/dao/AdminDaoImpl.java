package es.rural.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.rural.pojo.Admin;

@SuppressWarnings("unchecked")
@Transactional
@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Admin admin) {
		getSession().save(admin);
	}

	@Override
	public List<Admin> findAll() {
		Query query = getSession().createQuery("from Admin"); //usando HQL
		return query.list();
	}

	@Override
	public Admin findById(int id) {
		Criteria criteria = getSession().createCriteria(Admin.class);
		criteria.add(Restrictions.eq("idAd", id));
		Admin admin = (Admin) criteria.uniqueResult();
		admin.getDirecciones();
		return admin;
	}

	@Override
	public List<Admin> findByNombre(String nombre) {
		Criteria criteria = getSession().createCriteria(Admin.class);
		criteria.add(Restrictions.like("nombre", "%" + nombre + "%"));
		return criteria.list();
	}

	@Override
	public void update(Admin admin) {
		getSession().update(admin);
	}

	@Override
	public void delete(int idAd) {
		Admin admin = findById(idAd);
		getSession().delete(admin);
	}
	
	

}
