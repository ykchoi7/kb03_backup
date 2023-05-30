package sp0427.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import sp0427.dto.BbsDto;

@Repository
public class MyBbsDao {
	
	@Autowired
	private SqlSessionTemplate tpl;

	//전체를 뽑아야하기 때문에 selectList로 전체 뽑기
	public List<BbsDto> selectAll() {
		return tpl.selectList("selectAll");
	}

	//하나만 뽑아도되기 때문에 selectOne으로 하나만 뽑기
	public BbsDto selectOne(int no) {
		return tpl.selectOne("selectOne");
	}

	public int count() {
		return tpl.selectOne("count");
	}
	
}
