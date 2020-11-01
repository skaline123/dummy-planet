package mx.com.danito.api.sample.planet;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import mx.com.danito.api.sample.planet.service.PlanetService;

@SpringBootApplication
public class SampleProjectPlanetApplication {

	@Autowired
	PlanetService planetService;
	
	
	private final static Logger LOGGER = LogManager.getLogger(SampleProjectPlanetApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SampleProjectPlanetApplication.class, args);
	}

	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx)
    {
        return args ->
        {
        	LOGGER.log(Level.INFO, "Init --- Process to read files to Planet Payment");
        	planetService.masterProcess(args);
        	LOGGER.log(Level.INFO, "Finish --- Process to read files to Planet Payment ");
        };
    }
}
