package com.sanluis.laLigaAPI.equipo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sanluis.laLigaAPI.jugador.Jugador;

@Entity
@Table(name = "equipos")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String ciudad;
	private Integer fundacion;
	private Integer socios;
	private Integer penas;
	private String imagen;
	@OneToMany(
			mappedBy = "equipo",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<Jugador> jugadores;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Integer getFundacion() {
		return fundacion;
	}
	public void setFundacion(Integer fundacion) {
		this.fundacion = fundacion;
	}
	public Integer getSocios() {
		return socios;
	}
	public void setSocios(Integer socios) {
		this.socios = socios;
	}
	public Integer getPenas() {
		return penas;
	}
	public void setPenas(Integer penas) {
		this.penas = penas;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

}
