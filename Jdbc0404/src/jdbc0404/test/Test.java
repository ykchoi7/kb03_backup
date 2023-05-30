package jdbc0404.test;

import java.util.List;

import jdbc0404.dao.BbsDao;
import jdbc0404.dao.MemberDao;
import jdbc0404.dto.BbsDto;
import jdbc0404.dto.BbsNameDto;
import jdbc0404.dto.MemberCountDto;
import jdbc0404.dto.MemberDto;

/**MemberDao 기능 테스트용 클래스*/
public class Test {
	public static void main(String[] args) throws Exception {
		MemberDao dao = new MemberDao();
//		
//		//insert() 테스트
//		MemberDto dto = new MemberDto("user01", "1111", "유저01", "테스트유저01");
//		dao.insert(dto);
//		System.out.println("회원등록성공");
//		dto = new MemberDto("user02", "2222", "유저02", "테스트유저02");
//		dao.insert(dto);
//		System.out.println("회원등록성공");
		//=> 같은 ID를 사용하면 오류 발생
		
		
		//update() 테스트
//		dto.setIntro("테스트유저01-수정");
//		dao.update(dto);
//		System.out.println("회원수정 성공");
		
		
		//delete() 테스트
//		dao.delete(dto.getId());
//		System.out.println("회원삭제 성공");
		
		
		//count() 테스트
//		int count = dao.count();
//		System.out.println("등록회원수 = "+count);
		
		
		//selectOne() 테스트
//		dto = dao.selectOne("user02");
//		if (dto == null) 
//			System.out.println("미등록회원");
//		else
//			System.out.println(dto);
		
		
		//selectAll() 테스트
//		System.out.println("**전체출력**");
//		List<MemberDto> list = dao.selectAll();
//		for (MemberDto dto1 : list) {
//			System.out.println(dto1);
//		}
		
		
		//BBS 테스트 (게시물 관리)
//		BbsDao bbsDao = new BbsDao();
//		BbsDto bbs = new BbsDto("user01", "게시물", "게시물 관리 안내");
//		bbsDao.insert(bbs);
//		System.out.println("게시물 등록");
		
		//게시물 전체 출력
//		System.out.println("**게시물 전체 출력**");
//		List<BbsDto> list = bbsDao.selectAll();
//		for (BbsDto bbsDto : list) {
//			System.out.println(bbsDto);
//		}
		
		//게시물 전체 등록자 이름 출력
//		System.out.println("** 게시물 전체 등록자 이름 출력 **");
//        List<BbsNameDto> list = bbsDao.selectAllName();
//        for (BbsNameDto bbsDto : list) {
//            System.out.println(bbsDto);
//        }
        
        //사용자별 게시물 갯수를 출력하세요
        //사용자별 게시물 갯수 추출하는 SQL 작성 (join, 서브쿼리)
        //p.164 상호연관 서브쿼리 적용하면 좋음
        List<MemberCountDto> mcList = dao.selectCountAll();
        for (MemberCountDto mcd : mcList) {
			System.out.println(mcd);
		}
	}
}
