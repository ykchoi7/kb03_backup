package multicampus.kb03.mybatis_01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import multicampus.kb03.mybatis_01.entity.Bbs;


@Mapper
public interface BbsMapper {
    List<Bbs> findAll();
    Bbs findOne(@Param("no") int no);
    int save(@Param("bbs") Bbs bbs );
}
