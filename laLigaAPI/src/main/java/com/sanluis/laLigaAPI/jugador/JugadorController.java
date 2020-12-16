package com.sanluis.laLigaAPI.jugador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jugadores")
@CrossOrigin(origins = {"http://localhost:4200/", "*"})
public class JugadorController {
	
	@Autowired
	JugadorService jugadorService;
	
	@GetMapping
	public List<Jugador> getJugadores(){
		return null;
	}

	@GetMapping(value = "/equipo/{idEquipo}")
	public List<Jugador> getJugadoresByEquipo(@PathVariable("idEquipo") Integer idEquipo){
		return jugadorService.getJugadoresByEquipo(idEquipo);
	}

}
