package br.com.fiap.PetPass;

import br.com.fiap.PetPass.dto.SlackMessagesDTO;
import br.com.fiap.PetPass.utils.SlackUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetPassApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetPassApplication.class, args);

		//testSlackIntegration();
	}
}
