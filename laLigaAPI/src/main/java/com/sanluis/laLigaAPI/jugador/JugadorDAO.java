package com.sanluis.laLigaAPI.jugador;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanluis.laLigaAPI.equipo.Equipo;

public interface JugadorDAO extends JpaRepository<Jugador, Integer>{
	
	public List<Jugador> findByEquipo(Equipo equipo);

}
