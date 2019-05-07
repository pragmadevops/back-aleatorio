package com.kudo.devops.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kudo.devops.model.Participante;
import com.kudo.devops.participante.ParticipanteInterface;
import com.kudo.devops.participante.ParticipanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping("/devops")
@CrossOrigin
public class ParticipanteController {
	
	@Autowired
	ParticipanteService Iparticipante;
	
	@GetMapping("/obtenerTodosParticipantes")
	public List<Participante> obtenerParticipantes(){
		return Iparticipante.findAll();
	}
	
	@GetMapping("/obtenerParticipanteEstado/{estado}")
	public List<Participante> obtenerParticipantesEstado(@PathVariable(value="estado") int estado){
		return Iparticipante.findByEstado(estado);
	}
	
	@GetMapping("/obtenerParticipanteId/{id}")
	public Participante obtenerParticipanteId(@PathVariable(value="id") Long id){
		Participante participante =  Iparticipante.obtenerParticipanteId(id);
		return participante;
	}
	
	@PostMapping("/crearParticipante")
	public Participante crearParticipante(@RequestBody Participante participante) {
		return Iparticipante.crearParticipante(participante);
	}
	
	@PutMapping("/actualizarParticipante/{id}")
	public Participante actualizarParticipante(@PathVariable(value="id") Long id,
											@RequestBody Participante participante) {
		
		return Iparticipante.actualizarParticipante(id, participante);
	}
	

}
