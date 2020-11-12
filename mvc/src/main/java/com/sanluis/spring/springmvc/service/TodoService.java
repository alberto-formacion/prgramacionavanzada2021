package com.sanluis.spring.springmvc.service;

import java.util.List;

import com.sanluis.spring.springmvc.vo.Todo;

public interface TodoService {

	List<Todo> getTodos();
	Todo getTodoById(Integer id);
	void createOrUpdateTodo(Todo todo);
	void deleteTodo(Todo todo);

}
