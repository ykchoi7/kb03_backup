package multicampus.kb03.boot_jpa0504.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import multicampus.kb03.boot_jpa0504.entity.Bbs;

@Mapper
public interface BbsMapper {
	@Select("Select * from bbs order by no desc")
	List<Bbs> findAll();
	
	@Insert("Insert into bbs(no, title, writer_id, content, regdate) values (bbs_seq.nextval, #{bbs.title}, #{bbs.writer_id}, #{bbs.content}, sysdate)")
	int save(@Param("bbs") Bbs bbs);

}
