package com.sanluis.laLigaAPI.jugador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanluis.laLigaAPI.equipo.Equipo;

@Service
public class JugadorService {

	@Autowired
	JugadorDAO jugadorDAO;

	public List<Jugador> getJugadoresByEquipo(Integer idEquipo) {
		Equipo e = new Equipo();
		e.setId(idEquipo);
		return jugadorDAO.findByEquipo(e);
	}
}
