package com.kudoDevOps.kudoDevOps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.kudo.devops.KudoDevOpsApplication;
import com.kudo.devops.model.Participante;
import com.kudo.devops.participante.ParticipanteInterface;
import com.kudo.devops.participante.ParticipanteService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =KudoDevOpsApplication.class)
public class ParticipanteTest {
	
	private static final long ID = 123456L;
	private static final String NOMBRE = "Pedro Pruebas";
	private static final long ID2 = 1234567L;
	private static final String NOMBRE2 = "Juana Pruebas";
	private static final int ESTADO = 1;
	
	@Autowired
	private ParticipanteService participanteService;
	@MockBean
	private ParticipanteInterface participanteInterface;
	
	
	@Test
	public void crearParticipanteControllerTest() 
	{
		Mockito.when(participanteInterface.findAll()).thenReturn(Stream.
					of(new Participante(ID, NOMBRE, ESTADO),new Participante(ID2, NOMBRE2, ESTADO)).collect(Collectors.toList()));
		
		assertEquals(2, participanteService.findAll().size());
	}
	
	@Test
	public void obtenerParticipanteEstadoControllerTest() 
	{
		Mockito.when(participanteInterface.findByEstado(ESTADO)).thenReturn(Stream.
					of(new Participante(ID, NOMBRE, ESTADO),new Participante(ID2, NOMBRE2, ESTADO)).collect(Collectors.toList()));
		
		List<Participante> participantesActivos = participanteService.findByEstado(ESTADO);
		
		for (Participante participante : participantesActivos) {
			assertEquals(ESTADO, participante.getEstado());
		}
	}
	
	
	/*@Test
	public void crearParticipanteTest() throws Exception {

		Participante participante = new Participante(ID, NOMBRE, ESTADO);
		Participante participanteReturn;
		
		participanteReturn = participanteService.crearParticipante(participante);
		
		assertNotNull(participanteReturn);
		assertEquals(new Long(ID), participanteReturn.getId());
		assertEquals(1, participanteReturn.getEstado());
		assertEquals(NOMBRE, participanteReturn.getNombre());
		
		participanteService.eliminarParticipante(ID);
		
	}*/
	
	/*@Test
	public void obtenerParticipanteIdTest() throws Exception {

		Participante participante = new Participante(ID, NOMBRE, ESTADO);
		Participante participanteConsultado;
		
		participanteService.crearParticipante(participante);
		
		participanteConsultado = participanteService.obtenerParticipanteId(participante.getId());
		
		assertNotNull(participanteConsultado);
		assertEquals(new Long(ID), participanteConsultado.getId());
		assertEquals(ESTADO, participanteConsultado.getEstado());
		assertEquals(NOMBRE, participanteConsultado.getNombre());
		
		participanteService.eliminarParticipante(ID);
		
	}*/
	
	@Test
	public void obtenerParticipanteEstadoTest() throws Exception {

		
		List<Participante> participantesActivos = participanteService.findByEstado(ESTADO);
		
		for (Participante participante : participantesActivos) {
			assertEquals(ESTADO, participante.getEstado());
		}
		
		List<Participante> participantesInactivos = participanteService.findByEstado(0);
		
		for (Participante participante : participantesInactivos) {
			assertEquals(0, participante.getEstado());
		}
	}
	
	/*@Test
	public void actualizarParticipanteTest() throws Exception {

		Participante participante = new Participante(ID, NOMBRE, ESTADO);
		Participante participanteReturn;
		
		
		participanteService.crearParticipante(participante);
		participante.setEstado(0);
		participanteReturn = participanteService.actualizarParticipante(ID, participante);
		
		assertNotNull(participanteReturn);
		assertEquals(new Long(ID), participanteReturn.getId());
		assertEquals(0, participanteReturn.getEstado());
		assertEquals(NOMBRE, participanteReturn.getNombre());
		
		participanteService.eliminarParticipante(ID);
		
	}*/
	
	@Test
	public void obtenerTodosTest() throws Exception {

		List<Participante> participantesActivos = null;
		
		participantesActivos = participanteService.findAll();
		
		assertNotNull(participantesActivos);

		
	
		
	}

}
