package multicampus.kb03.boot0503;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import multicampus.kb03.boot0503.ifs.Greet;

@SpringBootApplication
public class Boot0503Application2 {

	public static void main(String[] args) {
		//방법1
		ConfigurableApplicationContext context = SpringApplication.run(Boot0503Application2.class, args);
		Greet greet = context.getBean(Greet.class);
//		//방법2
//		ConfigurableApplicationContext context = SpringApplication.run(Boot0503Application2.class, args);
//		context.getBean(boost0503Application2.class).execute;
		System.out.println(greet.greeting());
	}
	
	@Autowired
	private Greet greet;
	
	public void execute() {
		System.out.println(greet.greeting());
	}
}
