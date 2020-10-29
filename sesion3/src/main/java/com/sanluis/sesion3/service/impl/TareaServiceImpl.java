package com.sanluis.sesion3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanluis.sesion3.dao.TareaDAO;
import com.sanluis.sesion3.model.Tarea;
import com.sanluis.sesion3.service.TareaService;

@Service
public class TareaServiceImpl implements TareaService{
	
	@Autowired
	TareaDAO tareaDAO;
	
	public List<Tarea> listTareas(){
		return tareaDAO.listTareas();
	}

	public List<Tarea> getTareasByNombre(String nombre) {
		return tareaDAO.getTareasByNombre(nombre);
	}

	public List<Tarea> getTareasByNombreCriteria(String nombre) {
		return tareaDAO.getTareasByNombreCriteria(nombre);
	}

}
