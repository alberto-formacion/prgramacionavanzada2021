package com.sanluis.spring.springmvc.dao;

import java.util.List;

import com.sanluis.spring.springmvc.vo.Todo;

public interface TodoDAO {

	List<Todo> getTodos();
	Todo getTodoById(Integer id);
	void createOrUpdateTodo(Todo todo);
	void deleteTodo(Todo todo);
	
}
