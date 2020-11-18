package com.sanluis.sesion4.service;

import java.util.List;

import com.sanluis.sesion4.model.Tarea;

public interface TareaService {

	List<Tarea> getAllTareas();
	Tarea getTareaById(Integer id);
	List<Tarea> getTareaByNombre(String tarea);
	List<Tarea> getTareaByNombreQuery(String descripcion);
	public Tarea saveTarea(Tarea tarea);
	public Tarea deleteTarea(Tarea tarea);

}
