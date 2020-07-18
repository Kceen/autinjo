package rs.autinjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class AutinjoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutinjoSpringApplication.class, args);
	}

}
