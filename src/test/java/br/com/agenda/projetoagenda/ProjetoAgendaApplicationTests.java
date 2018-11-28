	package br.com.agenda.projetoagenda;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.agenda.projetoagenda.controller.ClienteController;
import br.com.agenda.projetoagenda.controller.PrincipalController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjetoAgendaApplicationTests {
	@Autowired
	private PrincipalController controller;
	@Autowired
	private ClienteController clienteController;
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(clienteController).isNotNull();
	}
	
	@Test
	public void homeControllerTest() throws Exception{
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("eu não acredito")));
	}
	
	@Test
	public void clienteControllerTest() throws Exception{
		this.mockMvc.perform(get("/cliente")).andDo(print()).andExpect(status().isOk()).andExpect(xpath("//table").exists()).andExpect(xpath("//td[contains(., 'Rogerinho')]").exists());
	}
}
