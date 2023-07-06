package com.nisiulinfosoft.springboot.app.persona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nisiulinfosoft.springboot.app.persona.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	@Query("SELECT p FROM Persona p WHERE p.dni LIKE %?1%"
            + " OR p.nombre LIKE %?1%"
            + " OR p.apellido LIKE %?1%"
            + " OR p.sexo LIKE %?1%"
            + " OR CONCAT(p.edad, '') LIKE %?1%")
    public List<Persona> search1(String texto);
	
	@Query("SELECT p FROM Persona p WHERE CONCAT(p.dni, p.nombre, p.apellido, p.sexo, p.edad) LIKE %?1%")
	public List<Persona> search2(String texto);

}
