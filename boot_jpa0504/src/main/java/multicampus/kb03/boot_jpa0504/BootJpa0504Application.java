package multicampus.kb03.boot_jpa0504;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties.ConfigureAction;
import org.springframework.context.ConfigurableApplicationContext;

import multicampus.kb03.boot_jpa0504.entity.Bbs;
import multicampus.kb03.boot_jpa0504.mapper.BbsMapper;

@SpringBootApplication
public class BootJpa0504Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootJpa0504Application.class, args);
		context.getBean(BootJpa0504Application.class).execute();
	}
	
	@Autowired
	private BbsMapper mapper;
	
	public void execute() {
		//insert();
		selectAll();
	}

	private void selectAll() {
		List<Bbs> all = mapper.findAll();
		System.out.println("***전체출력***");
		for (Bbs bbs : all) {
			System.out.println("*** "+ bbs);
		}
	}

	private void insert() {
		Bbs bbs = new Bbs();
		bbs.setTitle("boot mybatis 테스트");
		bbs.setWriter_id("user01");
		bbs.setContent("boot mybatis 테스트중");
		mapper.save(bbs);
	}
	
}
