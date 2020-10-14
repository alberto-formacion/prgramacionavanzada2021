package com.sanluis.sesion1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanluis.sesion1.dao.TareaDAO;
import com.sanluis.sesion1.model.Tarea;
import com.sanluis.sesion1.service.TareaService;

@Service
public class TareaServiceImpl implements TareaService{
	
	@Autowired
	TareaDAO tareaDAO;
	
	public List<Tarea> listTareas(){
		return tareaDAO.listTareas();
	}

}
