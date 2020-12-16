package com.sanluis.laLigaAPI.enums;

public enum Posicion {
	PORTERO("Portero"), 
	DEFENSA("Defensa"), 
	CENTROCAMPISTA("Centrocampista"), 
	DELANTERO("Delantero");
	
	private final String posicion;
	
	Posicion(String posicion){
		this.posicion = posicion;
	}

	public String getPosicion() {
		return posicion;
	}
	
}
