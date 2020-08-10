package br.com.fiap.PetPass.controller;

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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteControllerTest {

    @Autowired
    public WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testaRequisicaoPorIdSucesso() throws Exception {
        String url = "/clientes/1";
        this.mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("nome", equalTo("Jose Almeida")));
    }

    @Test
    public void testaRequisicaoPorIdFalha() throws Exception {
        String url = "/clientes/0";
        this.mvc.perform(get(url))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testaRequisicaoGetAll() throws Exception {
        String url = "/clientes";
        this.mvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    public void testaRequisicaoPorDocumentoSucesso() throws Exception {
        String url = "/clientes/documento?documento=53214";
        this.mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("nome", equalTo("Jose Almeida")));
    }

    @Test
    public void testaRequisicaoPorDocumentoFalha() throws Exception {
        String url = "/clientes/documento?documento=00000";
        this.mvc.perform(get(url))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testaDeleteFalha() throws Exception {
        String url = "/clientes/0";
        this.mvc.perform(delete(url))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testaPostSucesso() throws Exception {
        String url = "/clientes";
        this.mvc.perform(post(url)
                .content("{\n" +
                        "	\"nome\": \"Marcos\",\n" +
                        "	\"documento\": 12124,\n" +
                        "	\"plano\": \"PRATA\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

}
