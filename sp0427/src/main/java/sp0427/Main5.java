package sp0427;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import sp0427.dto.BbsDto;

public class Main5 {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate tpl = context.getBean(JdbcTemplate.class);
       
        //1개 숫자 추출
        String sql = "SELECT count(*) FROM BBS";
        Integer count = tpl.queryForObject(sql, Integer.class);
        System.out.println(count);
        
        //1개 문자열 추출
        sql = "SELECT title FROM BBS WHERE no=?";
        String title = tpl.queryForObject(sql, String.class, 41);
        System.out.println(title);
    }
}

