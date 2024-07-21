package backoffice_server.backoffice_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BackofficeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackofficeServerApplication.class, args);
	}

}
