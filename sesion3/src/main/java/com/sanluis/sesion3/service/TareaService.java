package com.sanluis.sesion3.service;

import java.util.List;

import com.sanluis.sesion3.model.Tarea;

public interface TareaService {
	
	public List<Tarea> listTareas();
	public List<Tarea> getTareasByNombre(String nombre);
	public List<Tarea> getTareasByNombreCriteria(String nombre);

}
