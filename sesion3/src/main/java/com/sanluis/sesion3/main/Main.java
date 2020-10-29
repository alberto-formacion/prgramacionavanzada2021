package com.sanluis.sesion3.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sanluis.sesion3.conf.AppConfig;
import com.sanluis.sesion3.model.Tarea;
import com.sanluis.sesion3.service.TareaService;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
	      
		TareaService tareaService = context.getBean(TareaService.class);
		
		List<Tarea> tareas = tareaService.listTareas();
		
		showTareas(tareas);
		
		tareas = tareaService.getTareasByNombre("goku");
		
		showTareas(tareas);
		
		tareas = tareaService.getTareasByNombreCriteria("PCR");
		
		showTareas(tareas);
		
		context.close();
	}
	
	public static void showTareas(List<Tarea> tareas) {
		for(Tarea t : tareas) {
			System.out.println("- " + t.getNombre() + "(" + t.getUsuario().getNombre() + ")");
		}
	}

}
