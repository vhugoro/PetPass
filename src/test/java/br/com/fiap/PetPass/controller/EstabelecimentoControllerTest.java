package br.com.fiap.PetPass.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstabelecimentoControllerTest {
	
	@Autowired
	public WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testaRequisicaoPorIdSucesso() throws Exception { 
		String url = "/estabelecimentos/1";
		this.mvc.perform(get(url))
					.andExpect(status().isOk())
					.andExpect(jsonPath("nome", equalTo("Pets Dogs")));
	}
	
	@Test
	public void testaRequisicaoPorIdFalha() throws Exception { 
		String url = "/estabelecimentos/0";
		this.mvc.perform(get(url))
					.andExpect(status().isNotFound());
	}
	
	@Test
	public void testaRequisicaoGetAll() throws Exception { 
		String url = "/estabelecimentos";
		this.mvc.perform(get(url))
					.andExpect(status().isOk());
	}
	
	@Test
	public void testaRequisicaoPorDocumentoSucesso() throws Exception { 
		String url = "/estabelecimentos/documento?documento=11111111111";
		this.mvc.perform(get(url))
					.andExpect(status().isOk())
					.andExpect(jsonPath("nome", equalTo("Pets Dogs")));
	}
	
	@Test
	public void testaRequisicaoPorDocumentoFalha() throws Exception { 
		String url = "/estabelecimentos/documento?documento=00000";
		this.mvc.perform(get(url))
					.andExpect(status().isNotFound());
	}
	
	@Test
	public void testaDeleteFalha() throws Exception { 
		String url = "/estabelecimentos/0";
		this.mvc.perform(delete(url))
					.andExpect(status().isNotFound());
	}
	
	@Test
	public void testaPostSucesso() throws Exception { 
		String url = "/estabelecimentos";
		this.mvc.perform(post(url)
				.content("{\n" + 
						"	\"nome\": \"Teste\",\n" + 
						"    \"documento\": 11111111112,\n" + 
						"    \"latitude\": -23.6741565,\n" + 
						"    \"longitude\": -46.7082601,\n" + 
						"    \"plano\": \"OURO\"\n" + 
						"}")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
	}

}
