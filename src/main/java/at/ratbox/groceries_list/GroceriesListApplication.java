package at.ratbox.groceries_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GroceriesListApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceriesListApplication.class, args);
	}

}
