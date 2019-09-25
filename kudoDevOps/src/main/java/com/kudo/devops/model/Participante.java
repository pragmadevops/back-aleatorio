package com.kudo.devops.model;


import javax.persistence.*;

@Entity
@Table(name="participante")

public class Participante {
	
	@Column
	private String nombre;
	@Id
	private Long id;
	@Column
	private int estado;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
