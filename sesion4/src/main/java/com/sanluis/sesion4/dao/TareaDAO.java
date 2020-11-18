package com.sanluis.sesion4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sanluis.sesion4.model.Tarea;

public interface TareaDAO extends JpaRepository<Tarea, Integer> {
	List<Tarea> findByNombreContaining(String nombre);
	
	@Query("select t from Tarea t where t.nombre like %?1%")
	List<Tarea> findByTareaQuery(String nombre);

}
