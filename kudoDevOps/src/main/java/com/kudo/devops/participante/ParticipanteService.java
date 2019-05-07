package com.kudo.devops.participante;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kudo.devops.model.Participante;

@Service
public class ParticipanteService {
	@Autowired
	private ParticipanteInterface Iparticipante;
	
	public List<Participante> findAll(){
		return Iparticipante.findAll();	
	}
	
	public List<Participante> findByEstado(int estado){
		return Iparticipante.findByEstado(estado);
	}
	

	public Participante obtenerParticipanteId(Long id){
		Optional<Participante> optionalEntity =  Iparticipante.findById(id);
		Participante participanteInterno = optionalEntity.get();
		return participanteInterno;
	}
	

	public Participante crearParticipante(Participante participante) {
		return Iparticipante.save(participante);
	}
	

	public Participante actualizarParticipante(Long id,Participante participante) {
		
	
		Participante participanteSave  =  obtenerParticipanteId(id);
		participanteSave.setEstado(participante.getEstado());
		Participante updateParticipante = crearParticipante(participanteSave);
		return updateParticipante;
	}
	
	public String eliminarParticipante(Participante participante) {
		Iparticipante.delete(participante);
		return "";
	}
	
}
