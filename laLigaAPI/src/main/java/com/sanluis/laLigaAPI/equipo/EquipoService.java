package com.sanluis.laLigaAPI.equipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {
	
	@Autowired
	private EquipoDAO equipoDAO;
	
	public List<Equipo> getEquipos(){
		return equipoDAO.findAll();
	}

	public Equipo saveEquipo(Equipo equipo) {
		return equipoDAO.save(equipo);
	}

}
