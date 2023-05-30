package sp0427.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sp0427.dto.BbsDto;

@Repository   //저장소
public class BbsDao {
	
	@Autowired
	private JdbcTemplate tpl;
	
	public List<BbsDto> selectAll() {
		String sql = "SELECT * FROM BBS ORDER BY no DESC";
        List<BbsDto> list = tpl.query(
        		sql, new BeanPropertyRowMapper<BbsDto>(BbsDto.class));
		
        return list;
	}

}
