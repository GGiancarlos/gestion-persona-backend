package com.nisiulinfosoft.springboot.app.persona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nisiulinfosoft.springboot.app.persona.model.Persona;
import com.nisiulinfosoft.springboot.app.persona.service.PersonaService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/personas")
	public ResponseEntity<List<Persona>> obtenerTodasPersonas(){
		return ResponseEntity.ok().body(personaService.obtenerTodasPersonas());
	}
	
	@GetMapping("/personas/buscar1/{texto}")
	public ResponseEntity<List<Persona>> buscarPorVariosCampos1(@PathVariable String texto){
		return ResponseEntity.ok().body(personaService.buscarPorVariosCampos1(texto));
	}
	
	@GetMapping("/personas/buscar2/{texto}")
	public ResponseEntity<List<Persona>> buscarPorVariosCampos2(@PathVariable String texto){
		return ResponseEntity.ok().body(personaService.buscarPorVariosCampos2(texto));
	}
	
	@GetMapping("/personas/{id}")
	public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable long id){
		return ResponseEntity.ok().body(personaService.obtenerPersonaPorId(id));
	}
	
	@PostMapping("/personas")
	public ResponseEntity<Persona> insertarPersona(@RequestBody Persona persona){
		return ResponseEntity.ok().body(this.personaService.insertarPersona(persona));
	}
	
	@PutMapping("/personas/{id}")
	public ResponseEntity<Persona> actualizarPersona(@PathVariable long id, @RequestBody Persona persona){
		persona.setId(id);
		return ResponseEntity.ok().body(this.personaService.actualizarPersona(persona));
	}
	
	@DeleteMapping("/personas/{id}")
	public ResponseEntity<String> eliminarPersona(@PathVariable long id){
		this.personaService.eliminarPersona(id);
		return ResponseEntity.ok().body("{ \"status\": \"OK\" }");
	}

}
