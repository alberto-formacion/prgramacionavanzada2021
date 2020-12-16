package com.sanluis.laLigaAPI.equipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipos")
@CrossOrigin(origins = {"http://localhost:4200/", "*"})
public class EquipoController {
	
	@Autowired
	private EquipoService equipoService;

	@GetMapping
	public List<Equipo> getEquipos(){
		return equipoService.getEquipos();
	}
	
	@PostMapping
	public Equipo saveEquipo(@RequestBody Equipo equipo){
		return equipoService.saveEquipo(equipo);
	}
}
