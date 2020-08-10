package br.com.fiap.PetPass.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fiap.PetPass.entity.Cliente;
import br.com.fiap.PetPass.enums.PlanoEnum;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository repo;

    @Test
    public void testaClientePorDocumento() {
        Cliente cliente = repo.findByDocumento(53214);
        assertThat(cliente != null);
    }

    @Test
    public void testaClientePorDocumentoInexistente() {
        Cliente cliente = repo.findByDocumento(11111);
        assertThat(cliente == null);
    }

    @Test
    public void testaClientePorNome() {
        Cliente cliente = repo.findByNome("Jose Almeida");
        assertThat(cliente != null);
    }

    @Test
    public void testaClientePorNomeInexistente() {
        Cliente cliente = repo.findByNome("XXXX");
        assertThat(cliente == null);
    }

    @Test
    public void testaClientePorPlano() {
        List<Cliente> clientes = repo.findAllByPlano(PlanoEnum.OURO);
        assertThat(!clientes.isEmpty());
    }

}
