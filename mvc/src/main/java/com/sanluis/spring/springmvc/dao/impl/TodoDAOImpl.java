package com.sanluis.spring.springmvc.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sanluis.spring.springmvc.dao.TodoDAO;
import com.sanluis.spring.springmvc.vo.Todo;

@Repository
public class TodoDAOImpl implements TodoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional(readOnly=true)
	public List<Todo> getTodos() {
		return currentSession()
				.getEntityManagerFactory()
				.createEntityManager()
				.createNamedQuery("todo.getTodos", Todo.class)
				.getResultList();
	}

	@Transactional(readOnly=true)
	public Todo getTodoById(Integer id) {
		
		return (Todo) currentSession().createQuery("select t from Todo t where t.id = :id").setParameter("id", id.intValue()).getSingleResult();
	}

	@Transactional(readOnly=false)
	public void createOrUpdateTodo(Todo todo) {
		currentSession().saveOrUpdate(todo);
	}

	@Transactional(readOnly=false)
	public void deleteTodo(Todo todo) {
		currentSession().delete(todo);
	}

}
