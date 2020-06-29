package br.com.fiap.PetPass;

import br.com.fiap.PetPass.dto.SlackMessagesDTO;
import br.com.fiap.PetPass.utils.SlackUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PetPassApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PetPassApplication.class, args);
	}

  @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PetPassApplication.class);
    }
}
