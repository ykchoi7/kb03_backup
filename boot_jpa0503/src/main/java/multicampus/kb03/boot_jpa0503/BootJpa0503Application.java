package multicampus.kb03.boot_jpa0503;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import multicampus.kb03.boot_jpa0503.entity.Bbs;
import multicampus.kb03.boot_jpa0503.entity.BbsCrudRepository;

@SpringBootApplication
public class BootJpa0503Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootJpa0503Application.class, args);
		context.getBean(BootJpa0503Application.class).execute();
	}
	
	@Autowired
	private BbsCrudRepository repository;
	
	private void execute() {
		Bbs bbs = new Bbs();
		bbs.setTitle("jpa test");
		bbs.setWriter_id("user01");
		bbs.setContent("jpa test content");
		bbs.setRegdate(new Date());
		repository.save(bbs);
	}

}
