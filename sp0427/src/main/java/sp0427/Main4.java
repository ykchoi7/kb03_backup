package sp0427;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import sp0427.dto.BbsDto;

public class Main4 {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate tpl = context.getBean(JdbcTemplate.class);
        String sql = "SELECT * FROM BBS WHERE no=?";
        //조건에 만족하는 열만 추출하는 방법  .queryForObject
        BbsDto dto = tpl.queryForObject(
        		sql, new BeanPropertyRowMapper<BbsDto>(BbsDto.class), 41);
        System.out.println(dto);
    }
}

