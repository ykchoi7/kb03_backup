package dao;

import java.util.List;

import dto.UserDto;

public interface UserDao {
	
	// 고객 등록
	int insertUser(UserDto userDto) throws Exception;
	
	// 고객 수정
	int updateUser(UserDto userDto) throws Exception;
	
	// 고객 삭제
	int deleteUser(int userSeq) throws Exception;
	
	// 고객 전체 조회
	List<UserDto> selectAll() throws Exception;
	
	// 고객 1건 조회
	UserDto selectOne(int userSeq) throws Exception;
}
