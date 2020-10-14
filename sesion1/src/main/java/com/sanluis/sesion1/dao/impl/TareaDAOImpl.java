package com.sanluis.sesion1.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sanluis.sesion1.dao.TareaDAO;
import com.sanluis.sesion1.model.Tarea;

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
}
