package multicampus.kb03.mybatis_01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import multicampus.kb03.mybatis_01.entity.Bbs;
import multicampus.kb03.mybatis_01.mapper.BbsMapper;

@SpringBootApplication
public class Mybatis01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Mybatis01Application.class, args);
		context.getBean(Mybatis01Application.class).execute();
	}

	@Autowired
	private BbsMapper bbsMapper;
	
	private void execute() {
		listOne();
	}

	private void listOne() {
		Bbs bbs = bbsMapper.findOne(23);//없으면 null
		System.out.println(bbs);
	}

	private void listAll() {
		List<Bbs> findAll = bbsMapper.findAll();
		System.out.println(findAll);
	}

}
