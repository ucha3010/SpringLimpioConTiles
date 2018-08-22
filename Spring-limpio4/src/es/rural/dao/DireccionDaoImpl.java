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

import es.rural.pojo.Admin;
import es.rural.pojo.Direccion;

@SuppressWarnings("unchecked")
@Transactional
@Repository
public class DireccionDaoImpl implements DireccionDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Direccion direccion) {
		getSession().save(direccion);
	}

	@Override
	public List<Direccion> findAll() {
		Query query = getSession().createQuery("from Direccion"); //usando HQL
		return query.list();
	}

	@Override
	public Direccion findById(int id) {
		Criteria criteria = getSession().createCriteria(Direccion.class);
		criteria.add(Restrictions.eq("idDir", id));
		return (Direccion) criteria.uniqueResult();
	}

	@Override
	public List<Direccion> findByCalle(String calle) {
		Criteria criteria = getSession().createCriteria(Direccion.class);
		criteria.add(Restrictions.like("calle", "%" + calle + "%"));
		return criteria.list();
	}

	@Override
	public void update(Direccion direccion) {
		getSession().update(direccion);
	}

	@Override
	public void delete(int idDir) {
		Direccion direccion = findById(idDir);
		getSession().delete(direccion);
	}

	@Override
	public List<Direccion> findByAdmin(Admin admin) {
		//esta sentencia hace lo mismo que las dos líneas de abajo
//		Criteria criteria = getSession().createCriteria(Direccion.class)
//				.setFetchMode("admin", FetchMode.JOIN)
//				.add(Restrictions.eq("admin.idAd", admin.getIdAd()))
//				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		Criteria criteria = getSession().createCriteria(Direccion.class);
		criteria.add(Restrictions.eq("admin", admin));
		return criteria.list();
	}
	
	
	

}
