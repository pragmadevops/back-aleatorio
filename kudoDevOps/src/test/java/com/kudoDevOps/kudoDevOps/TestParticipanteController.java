package com.kudoDevOps.kudoDevOps;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kudo.devops.KudoDevOpsApplication;
import com.kudo.devops.controller.ParticipanteController;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = KudoDevOpsApplication.class)
public class TestParticipanteController {
	
	
	private MockMvc mockMvcCliente;
	
	@Autowired
	private ParticipanteController participanteController;
	
	@Before
	public void cargarCliente() throws Exception{
		mockMvcCliente = MockMvcBuilders.standaloneSetup(participanteController).build();
	}
	
	@Test
	public void obtenerTodosParticipantes() throws Exception {	
		mockMvcCliente.perform(
				MockMvcRequestBuilders.get("/devops/obtenerTodosParticipantes").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
