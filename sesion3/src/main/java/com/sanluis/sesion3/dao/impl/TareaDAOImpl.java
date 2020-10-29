package com.sanluis.sesion3.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sanluis.sesion3.dao.TareaDAO;
import com.sanluis.sesion3.model.Tarea;

@Repository
public class TareaDAOImpl implements TareaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public List<Tarea> listTareas() {
		@SuppressWarnings("unchecked")
		TypedQuery<Tarea> query = sessionFactory.getCurrentSession().createQuery("from Tarea");
		return query.getResultList();
	}
	
	@Transactional(readOnly = true)
	public List<Tarea> getTareasByNombre(String nombre){
		TypedQuery<Tarea> q = sessionFactory.createEntityManager().createNamedQuery("get_tarea_by_nombre", Tarea.class);
		q.setParameter("nombre", "%"+nombre+"%");
		return q.getResultList();
	}
	
	@Transactional(readOnly = true)
	public List<Tarea> getTareasByNombreCriteria(String nombre){
		EntityManager em = sessionFactory.createEntityManager();

		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<Tarea> criteria = builder.createQuery(Tarea.class);
		Root<Tarea> root = criteria.from(Tarea.class);
		criteria.select(root);
		
		criteria.where(builder.like(root.<String>get("nombre"), "%"+nombre+"%"));
		
		return em.createQuery(criteria).getResultList();
		
	}
}
