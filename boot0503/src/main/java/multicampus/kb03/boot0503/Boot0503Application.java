package multicampus.kb03.boot0503;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import multicampus.kb03.boot0503.ifs.Greet;

@SpringBootApplication
public class Boot0503Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Boot0503Application.class, args);
		Greet greet = context.getBean(Greet.class);
		System.out.println(greet.greeting());
	}

}
