package com.kudoDevOps.kudoDevOps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kudo.devops.KudoDevOpsApplication;
import com.kudo.devops.model.Participante;
import com.kudo.devops.participante.ParticipanteService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =KudoDevOpsApplication.class)
public class ParticipanteTest {
	
	@Autowired
	private ParticipanteService SParticipante;

	
	@Test
	public void testCrearParticipante() throws Exception {

		Participante participante = new Participante();
		Participante participanteReturn;
		
		participante.setEstado(1);
		participante.setId(new Long("123456"));
		participante.setNombre("Test Name");
		
		participanteReturn = SParticipante.crearParticipante(participante);
		
		assertNotNull(participanteReturn);
		assertEquals(new Long("123456"), participanteReturn.getId());
		assertEquals(1, participanteReturn.getEstado());
		assertEquals("Test Name", participanteReturn.getNombre());
		
		SParticipante.eliminarParticipante(participanteReturn);
		
	}
	
	@Test
	public void testObtenerParticipanteId() throws Exception {

		Participante participante = new Participante();
		Participante participanteConsultado;
		participante.setEstado(1);
		participante.setId(new Long("123456"));
		participante.setNombre("Test Name");
		
		SParticipante.crearParticipante(participante);
		
		participanteConsultado = SParticipante.obtenerParticipanteId(participante.getId());
		
		assertNotNull(participanteConsultado);
		assertEquals(new Long("123456"), participanteConsultado.getId());
		assertEquals(1, participanteConsultado.getEstado());
		assertEquals("Test Name", participanteConsultado.getNombre());
		
		SParticipante.eliminarParticipante(participanteConsultado);
		
	}
	
	@Test
	public void testObtenerParticipanteEstado() throws Exception {

		
		List<Participante> participantesActivos = SParticipante.findByEstado(1);
		
		for (Participante participante : participantesActivos) {
			assertEquals(1, participante.getEstado());
		}
		
		List<Participante> participantesInactivos = SParticipante.findByEstado(0);
		
		for (Participante participante : participantesInactivos) {
			assertEquals(0, participante.getEstado());
		}
	}
	
	@Test
	public void testActualizarParticipante() throws Exception {

		Participante participante = new Participante();
		Participante participanteReturn;
		
		participante.setEstado(1);
		participante.setId(new Long("123456"));
		participante.setNombre("Test Name");
		
		SParticipante.crearParticipante(participante);
		participante.setEstado(0);
		participanteReturn = SParticipante.actualizarParticipante(new Long("123456"), participante);
		
		assertNotNull(participanteReturn);
		assertEquals(new Long("123456"), participanteReturn.getId());
		assertEquals(0, participanteReturn.getEstado());
		assertEquals("Test Name", participanteReturn.getNombre());
		
		SParticipante.eliminarParticipante(participanteReturn);
		
	}
	
	@Test
	public void testObtenerTodos() throws Exception {

		List<Participante> participantesActivos = null;
		
		participantesActivos = SParticipante.findAll();
		
		assertNotNull(participantesActivos);

		
	
		
	}

}
