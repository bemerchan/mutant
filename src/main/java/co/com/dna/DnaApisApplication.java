package co.com.dna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DnaApisApplication {

    public static void main(final String[] args) {
        SpringApplication.run(DnaApisApplication.class, args);
    }

}
