package com.kudo.devops.participante;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kudo.devops.model.Participante;

@Service
public class ParticipanteService {
	@Autowired
	private ParticipanteInterface participanteInterface;
	
	public List<Participante> findAll(){
		return participanteInterface.findAll();	
	}
	
	public List<Participante> findByEstado(int estado){
		return participanteInterface.findByEstado(estado);
	}
	

	public Participante obtenerParticipanteId(Long id){
		Optional<Participante> optionalEntity =  participanteInterface.findById(id);
		Participante participante = new Participante();
		
		if(optionalEntity.isPresent()) {
			return optionalEntity.get();
		}else {
			return participante;
		}
		
		
	}
	

	public Participante crearParticipante(Participante participante) {
		return participanteInterface.save(participante);
	}
	

	public Participante actualizarParticipante(Long id,Participante participante) {
		
	
		Participante participanteSave  =  obtenerParticipanteId(id);
		participanteSave.setEstado(participante.getEstado());
		return crearParticipante(participanteSave);
	}
	
	public Participante eliminarParticipante(Long id) {
		Participante participanteDelete = obtenerParticipanteId(id);
		participanteInterface.delete(participanteDelete);
		return participanteDelete;
	}
	
}
