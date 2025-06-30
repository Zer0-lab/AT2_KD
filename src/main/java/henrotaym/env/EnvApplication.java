package henrotaym.env;

import henrotaym.env.configurations.RickAndMortyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RickAndMortyProperties.class)
@SpringBootApplication
public class EnvApplication {

  public static void main(String[] args) {
    SpringApplication.run(EnvApplication.class, args);
  }
}
