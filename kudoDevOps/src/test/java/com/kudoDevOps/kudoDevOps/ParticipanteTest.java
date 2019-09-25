package com.kudoDevOps.kudoDevOps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kudo.devops.KudoDevOpsApplication;
import com.kudo.devops.controller.ParticipanteController;
import com.kudo.devops.model.Participante;
import com.kudo.devops.participante.ParticipanteService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =KudoDevOpsApplication.class)
public class ParticipanteTest {
	
	private static final long ID = 123456L;
	private static final String NOMBRE = "Test Name";
	
	//@Autowired
	private ParticipanteService participanteService;
	private ParticipanteController participanteController;
	
	@Before
	public void setUp() {
		participanteService = Mockito.mock(ParticipanteService.class);
		participanteController = new ParticipanteController(participanteService);
	}
	
	@Test
	public void testCrearParticipanteController() throws Exception{
		
		Participante participante = new Participante();
		
		participante.setEstado(1);
		participante.setId(ID);
		participante.setNombre(NOMBRE);
		
		Mockito.when(participanteService.crearParticipante(participante)).thenReturn(participante);
		
		assertNotNull(participante);
		assertEquals(new Long(ID), participante.getId());
		assertEquals(1, participante.getEstado());
		assertEquals(NOMBRE, participante.getNombre());
	}
	
	
	@Test
	public void testCrearParticipante() throws Exception {

		Participante participante = new Participante();
		Participante participanteReturn;
		
		participante.setEstado(1);
		participante.setId(ID);
		participante.setNombre(NOMBRE);
		
		participanteReturn = participanteService.crearParticipante(participante);
		
		assertNotNull(participanteReturn);
		assertEquals(new Long(ID), participanteReturn.getId());
		assertEquals(1, participanteReturn.getEstado());
		assertEquals(NOMBRE, participanteReturn.getNombre());
		
		participanteService.eliminarParticipante(ID);
		
	}
	
	@Test
	public void testObtenerParticipanteId() throws Exception {

		Participante participante = new Participante();
		Participante participanteConsultado;
		participante.setEstado(1);
		participante.setId(ID);
		participante.setNombre(NOMBRE);
		
		participanteService.crearParticipante(participante);
		
		participanteConsultado = participanteService.obtenerParticipanteId(participante.getId());
		
		assertNotNull(participanteConsultado);
		assertEquals(new Long(ID), participanteConsultado.getId());
		assertEquals(1, participanteConsultado.getEstado());
		assertEquals(NOMBRE, participanteConsultado.getNombre());
		
		participanteService.eliminarParticipante(ID);
		
	}
	
	@Test
	public void testObtenerParticipanteEstado() throws Exception {

		
		List<Participante> participantesActivos = participanteService.findByEstado(1);
		
		for (Participante participante : participantesActivos) {
			assertEquals(1, participante.getEstado());
		}
		
		List<Participante> participantesInactivos = participanteService.findByEstado(0);
		
		for (Participante participante : participantesInactivos) {
			assertEquals(0, participante.getEstado());
		}
	}
	
	@Test
	public void testActualizarParticipante() throws Exception {

		Participante participante = new Participante();
		Participante participanteReturn;
		
		participante.setEstado(1);
		participante.setId(ID);
		participante.setNombre(NOMBRE);
		
		participanteService.crearParticipante(participante);
		participante.setEstado(0);
		participanteReturn = participanteService.actualizarParticipante(ID, participante);
		
		assertNotNull(participanteReturn);
		assertEquals(new Long(ID), participanteReturn.getId());
		assertEquals(0, participanteReturn.getEstado());
		assertEquals(NOMBRE, participanteReturn.getNombre());
		
		participanteService.eliminarParticipante(ID);
		
	}
	
	@Test
	public void testObtenerTodos() throws Exception {

		List<Participante> participantesActivos = null;
		
		participantesActivos = participanteService.findAll();
		
		assertNotNull(participantesActivos);

		
	
		
	}

}
