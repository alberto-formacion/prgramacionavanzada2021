package com.sanluis.sesion1.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sanluis.sesion1.conf.AppConfig;
import com.sanluis.sesion1.model.Tarea;
import com.sanluis.sesion1.service.TareaService;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
	      
		TareaService tareaService = context.getBean(TareaService.class);
		
		List<Tarea> tareas = tareaService.listTareas();
		
		for(Tarea t : tareas) {
			System.out.println("- " + t.getNombre());
		}
		
		context.close();
	}

}
