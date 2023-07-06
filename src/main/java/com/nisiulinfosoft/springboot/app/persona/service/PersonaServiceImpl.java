package com.nisiulinfosoft.springboot.app.persona.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nisiulinfosoft.springboot.app.persona.exception.ResourceNotFoundException;
import com.nisiulinfosoft.springboot.app.persona.model.Persona;
import com.nisiulinfosoft.springboot.app.persona.repository.PersonaRepository;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Persona insertarPersona(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public Persona actualizarPersona(Persona persona) {
		Optional<Persona> personaDb = this.personaRepository.findById(persona.getId());

		if (personaDb.isPresent()) {
			Persona personatUpdate = personaDb.get();

			personatUpdate.setId(persona.getId());
			personatUpdate.setDni(persona.getDni());
			personatUpdate.setNombre(persona.getNombre());
			personatUpdate.setApellido(persona.getApellido());
			personatUpdate.setEdad(persona.getEdad());
			personatUpdate.setSexo(persona.getSexo());
			personatUpdate.setFechaNacimiento(persona.getFechaNacimiento());
			personatUpdate.setCelular(persona.getCelular());
			personatUpdate.setGustos(persona.getGustos());
			personatUpdate.setNotas(persona.getNotas());
			personatUpdate.setCargos(persona.getCargos());

			personaRepository.save(personatUpdate);
			return personatUpdate;
		} else {
			throw new ResourceNotFoundException("No se encontro registro con el id: " + persona.getId());
		}
	}

	@Override
	public List<Persona> obtenerTodasPersonas() {
		return this.personaRepository.findAll();
	}
	
	@Override
	public List<Persona> buscarPorVariosCampos1(String texto) {
		return this.personaRepository.search1(texto);
	}

	@Override
	public List<Persona> buscarPorVariosCampos2(String texto) {
		return this.personaRepository.search2(texto);
	}

	@Override
	public Persona obtenerPersonaPorId(long personaId) {
		Optional<Persona> personaDb = this.personaRepository.findById(personaId);

		if (personaDb.isPresent()) {
			return personaDb.get();
		} else {
			throw new ResourceNotFoundException("No se encontro registro con el id: " + personaId);
		}
	}

	@Override
	public void eliminarPersona(long personaId) {
		Optional<Persona> personaDb = this.personaRepository.findById(personaId);

		if (personaDb.isPresent()) {
			this.personaRepository.delete(personaDb.get());
		} else {
			throw new ResourceNotFoundException("No se encontro registro con el id: " + personaId);
		}
	}

}
