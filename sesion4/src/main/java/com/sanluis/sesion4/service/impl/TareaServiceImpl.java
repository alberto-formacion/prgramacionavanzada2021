package com.sanluis.sesion4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanluis.sesion4.dao.TareaDAO;
import com.sanluis.sesion4.model.Tarea;
import com.sanluis.sesion4.service.TareaService;

@Service
public class TareaServiceImpl implements TareaService{
	
	@Autowired
	TareaDAO tareaDAO;
	
	public List<Tarea> getAllTareas(){
		return tareaDAO.findAll();
	}
	
	public Tarea getTareaById(Integer id) {
		return tareaDAO.getOne(id);
	}
	
	public List<Tarea> getTareaByNombre(String tarea){
		return tareaDAO.findByNombreContaining(tarea);
	}
	
	public List<Tarea> getTareaByNombreQuery(String descripcion){
		return tareaDAO.findByTareaQuery(descripcion);
	}

	public Tarea saveTarea(Tarea tarea) {
		return tareaDAO.save(tarea);
	}

	public Tarea deleteTarea(Tarea tarea) {
		tareaDAO.delete(tarea);
		return tarea;
	}	


}
