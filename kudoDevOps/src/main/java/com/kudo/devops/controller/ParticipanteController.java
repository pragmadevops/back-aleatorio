package com.kudo.devops.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kudo.devops.model.Participante;
import com.kudo.devops.participante.ParticipanteInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/devops")
@CrossOrigin
public class ParticipanteController {
	
	@Autowired
	ParticipanteInterface participanteInterface;
	
	@GetMapping("/obtenerTodosParticipantes")
	public List<Participante> obtenerParticipantes(){
		return participanteInterface.findAll();
	}
	
	@GetMapping("/obtenerParticipanteEstado/{estado}")
	public List<Participante> obtenerParticipantesEstado(@PathVariable(value="estado") int estado){
		return participanteInterface.findByEstado(estado);
	}
	
	@GetMapping("/obtenerParticipanteId/{id}")
	public Participante obtenerParticipanteId(@PathVariable(value="id") Long id){
		Optional<Participante> optionalEntity =  participanteInterface.findById(id);
		Participante participanteInterno = optionalEntity.get();
		return participanteInterno;
	}
	
	@PostMapping("/crearParticipante")
	public Participante crearParticipante(@RequestBody Participante participante) {
		return participanteInterface.save(participante);
	}
	
	@PutMapping("/actualizarParticipante/{id}")
	public Participante actualizarParticipante(@PathVariable(value="id") Long id,
											@RequestBody Participante participante) {
		
	
		Optional<Participante> optionalEntity =  participanteInterface.findById(id);
		Participante participanteInterno = optionalEntity.get();
		participanteInterno.setEstado(participante.getEstado());
		Participante updateParticipante = participanteInterface.save(participanteInterno);
		return updateParticipante;
	}
	
	/*@PutMapping("/actualizarParticipante/{id}")
	public Participante actualizarParticipante(@PathVariable(value="id")Long parId,
												@RequestBody Participante detalleParticipante) {
		Participante participante = participanteInterface.findById(parId);
		return
	}*/
	

}
