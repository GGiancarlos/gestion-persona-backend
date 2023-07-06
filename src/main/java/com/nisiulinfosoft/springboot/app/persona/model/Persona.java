package com.nisiulinfosoft.springboot.app.persona.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "celular")
	private String celular;
	
	@Column(name = "gustos")
	private String gustos;
	
	@Column(name = "notas")
	private BigDecimal notas;
	
	@Column(name = "cargos")
	private String cargos;

	public Persona() {
		
	}

	public Persona(long id, String dni, String nombre, String apellido, int edad, String sexo, Date fechaNacimiento,
			String celular, String gustos, BigDecimal notas, String cargos) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.gustos = gustos;
		this.notas = notas;
		this.cargos = cargos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getGustos() {
		return gustos;
	}

	public void setGustos(String gustos) {
		this.gustos = gustos;
	}

	public BigDecimal getNotas() {
		return notas;
	}

	public void setNotas(BigDecimal notas) {
		this.notas = notas;
	}

	public String getCargos() {
		return cargos;
	}

	public void setCargos(String cargos) {
		this.cargos = cargos;
	}

}
