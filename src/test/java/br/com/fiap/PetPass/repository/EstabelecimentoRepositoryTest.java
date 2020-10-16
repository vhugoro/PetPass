package br.com.fiap.PetPass.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fiap.PetPass.entity.Estabelecimento;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstabelecimentoRepositoryTest {

    @Autowired
    private EstabelecimentoRepository repo;

//    @Test
//    @Ignore
//    public void testaPorDocumento() {
//        Estabelecimento estabelecimento = repo.findByDocumento(11111111111L);
//        assertThat(estabelecimento.getNome().equals("Pets Dogs"));
//    }

    @Test
    public void testaPorDocumentoInexistente() {
        Estabelecimento estabelecimento = repo.findByDocumento(00L);
        assertThat(estabelecimento == null);
    }

//    @Test
//    @Ignore
//    public void testaPorNome() {
//        Estabelecimento estabelecimento = repo.findByNome("Pets Dogs");
//        assertThat(estabelecimento.getDocumento().equals(11111111111L));
//    }

    @Test
    public void testaPorNomeInexistente() {
        Estabelecimento estabelecimento = repo.findByNome("AAA");
        assertThat(estabelecimento == null);
    }

}
