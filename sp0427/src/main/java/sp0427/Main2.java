package sp0427;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main2 {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate tpl = context.getBean(JdbcTemplate.class);
        String sql = "INSERT INTO BBS(no, title, writer_id, content, regdate)";
        sql += "VALUES(BBS_SEQ.nextval, ?,?,?, SYSDATE)";
        tpl.update(sql, "sp_title", "user01", "스프링테스트");
        System.out.println("등록성공");
    }
}

