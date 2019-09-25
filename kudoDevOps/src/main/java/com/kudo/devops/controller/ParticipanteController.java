package com.kudo.devops.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kudo.devops.model.Participante;
import com.kudo.devops.service.ParticipanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/devops")
@CrossOrigin
public class ParticipanteController {
	
	@Autowired
	ParticipanteService participanteService;
	
	public ParticipanteController(ParticipanteService participanteService2) {
		this.participanteService = participanteService2;
	}

	@GetMapping("/obtenerTodosParticipantes")
	public List<Participante> obtenerParticipantes(){
		return participanteService.findAll();
	}
	
	@GetMapping("/obtenerParticipanteEstado/{estado}")
	public List<Participante> obtenerParticipantesEstado(@PathVariable(value="estado") int estado){
		return participanteService.findByEstado(estado);
	}
	
	@GetMapping("/obtenerParticipanteId/{id}")
	public Participante obtenerParticipanteId(@PathVariable(value="id") Long id){
		return participanteService.obtenerParticipanteId(id);
		
	}
	
	@PostMapping("/crearParticipante")
	public Participante crearParticipante(@RequestBody Participante participante) {
		Participante p = participanteService.crearParticipante(participante);
		p.setId(123456L);	
		return p;
	}
	
	@PutMapping("/actualizarParticipante/{id}")
	public Participante actualizarParticipante(@PathVariable(value="id") Long id,
											@RequestBody Participante participante) {
		
		return participanteService.actualizarParticipante(id, participante);
	}
	
	@DeleteMapping("/eliminarParticipante/{id}")
	public Participante eliminarParticipante(@PathVariable(value="id") Long id) {
		return participanteService.eliminarParticipante(id);
	}
	

}
