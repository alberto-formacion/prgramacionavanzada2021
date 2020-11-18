package com.sanluis.sesion4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanluis.sesion4.model.Tarea;
import com.sanluis.sesion4.service.TareaService;

@RestController
@RequestMapping("tareas")
public class TareaController {
	@Autowired
	TareaService tareaService;
	
	@GetMapping
	List<Tarea> getAllTareas(){
		return tareaService.getAllTareas();
	}
	
	@GetMapping(value = "/search/tarea/{nombre}")
	List<Tarea> getTareaById(@PathVariable String nombre) {
		return tareaService.getTareaByNombre(nombre);
	}
	
	@GetMapping(value = "/search/descripcion/{nombre}")
	List<Tarea> getTareaByDescripcion(@PathVariable String nombre) {
		return tareaService.getTareaByNombreQuery(nombre);
	}
	
	@GetMapping(value = "/{id}")
	Tarea getTareaById(@PathVariable Integer id) {
		return tareaService.getTareaById(id);
	}
	
	@PostMapping
	Tarea saveTarea(@RequestBody Tarea tarea) {
		return tareaService.saveTarea(tarea);
	}
	
	@DeleteMapping
	Tarea deleteTarea(@RequestBody Tarea tarea) {
		return tareaService.deleteTarea(tarea);
	}
}
