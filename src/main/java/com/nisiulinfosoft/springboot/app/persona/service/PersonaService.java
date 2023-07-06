package com.nisiulinfosoft.springboot.app.persona.service;

import java.util.List;

import com.nisiulinfosoft.springboot.app.persona.model.Persona;

public interface PersonaService {
	
	Persona insertarPersona(Persona persona);

	Persona actualizarPersona(Persona persona);

	List<Persona> obtenerTodasPersonas();
	
	List<Persona> buscarPorVariosCampos1(String texto);
	
	List<Persona> buscarPorVariosCampos2(String texto);

	Persona obtenerPersonaPorId(long personaId);

	void eliminarPersona(long id);

}
