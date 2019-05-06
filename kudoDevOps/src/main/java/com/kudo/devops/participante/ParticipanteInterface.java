package com.kudo.devops.participante;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.kudo.devops.model.Participante;

@Repository
public interface ParticipanteInterface extends JpaRepository<Participante, Long> {
	
	List<Participante> findByEstado(int estado);
	
}
