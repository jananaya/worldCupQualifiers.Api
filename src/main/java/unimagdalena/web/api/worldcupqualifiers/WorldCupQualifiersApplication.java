package unimagdalena.web.api.worldcupqualifiers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "unimagdalena.web.api.worldcupqualifiers")
public class WorldCupQualifiersApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldCupQualifiersApplication.class, args);
	}

}
