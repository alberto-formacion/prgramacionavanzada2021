package com.sanluis.spring.springmvc.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanluis.spring.springmvc.service.TodoService;
import com.sanluis.spring.springmvc.vo.Todo;

@Controller
@RequestMapping("/todos")
public class TodoController{
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping
	public String getTodos(Model model) {
		
		List<Todo> todos = todoService.getTodos();
		
		model.addAttribute("todos", todos);
		model.addAttribute("todo", new Todo());
		
		return "index";
	}
	
	@PostMapping
	public String saveOrUpdateTodo(@ModelAttribute("todo")Todo todo) {
		
		todoService.createOrUpdateTodo(todo);
		
		return "redirect:/todos";
	}
	
	@GetMapping("/{id}")
	public String getTodo(@PathVariable("id") Integer id, Model model) {
		
		Todo todo = todoService.getTodoById(id);
		
		model.addAttribute("todo", todo);
		
		return "detalleTodo";
	}
	
	@PostMapping("/delete")
	public String deleteTodo(@ModelAttribute("todo")Todo todo) {
		
		todoService.deleteTodo(todo);
		
		return "redirect:/todos";
	}

}
