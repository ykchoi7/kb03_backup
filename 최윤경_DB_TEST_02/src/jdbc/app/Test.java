package jdbc.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dao.CourseDao;
import jdbc.dao.StudentDao;
import jdbc.dao.TeacherDao;
import jdbc.dto.CourseDto;
import jdbc.dto.CourseRegDto;
import jdbc.dto.StudentDto;
import jdbc.dto.TeacherDto;
import jdbc.dao.CourseRegDao;

public class Test {
	public static void main(String[] args) throws Exception {
		//#1. 학생등록
		insertStudents();
		//#2. 교수등록
		insertTeachers();
		//#3. 강의과목등록
		insert강의과목();
		//#4. 수강신청
		insert수강신청();
		//#5. 수강신청상세정보출력
		select수강신청상세정보출력();//
		//#6. 학생별 신청과목수 출력
		select학생별신청과목수출력();//
		//#7. 교수별 개설과목 갯수 출력
		select교수별개설과목수();
		//#8. 수강인원미달과목상세출력
		select수강인원미달과목상세출력();//
	}

	private static void select수강인원미달과목상세출력() throws Exception {//
		/*
		 * 출력형식: 과목번호,과목이름,교수번호,교수이름,정원,신청수
		 * 다 가져와서 if문으로 출력 - 과목 당 신청수 < 정원 -> 수강인원 미달 과목
		 */		
		List<CourseDto> courseList = null;
		CourseDao coDao = new CourseDao();
		courseList = coDao.select수강인원미달과목상세출력();
		System.out.println("***수강인원미달과목상세***");
		
		for (CourseDto courseDto : courseList) {
			if (courseDto.getTotal() > courseDto.getRegnum()) {
				System.out.println(courseDto.getCourse_no() +", "+ courseDto.getName()
				+", "+ courseDto.getTeach_id() +", "+ courseDto.getTeachername() +", "+ courseDto.getTotal()
				+", "+ courseDto.getRegnum());
			}
		}
	}

	private static void select학생별신청과목수출력() throws Exception {//
		/*
		 * 출력형식: 학번,학생이름,전공,학년,신청과목수
		 * 학생-신청과목 테이블 조인 + 과목 수 count
		 */
		
		List<StudentDto> studentList = null;
		StudentDao stDao = new StudentDao();
		studentList = stDao.select학생별신청과목수출력();
		System.out.println("***학생별신청과목수()***");
		
		for (StudentDto studentDto : studentList) {
			System.out.println("학번: " + studentDto.getStudent_id());
			System.out.println("학생이름: " + studentDto.getName());
			System.out.println("전공: " + studentDto.getMajor());
			System.out.println("학년: " + studentDto.getGrade());
			System.out.println("신청과목수: "+ studentDto.getCnt());
			System.out.println("-------------------------------------");
		}
	}

	private static void select수강신청상세정보출력() throws Exception {//
		/*
		 * 출력형식: 신청번호,과목번호,과목이름,교수번호,교수이름,학생번호,학생이름,등록일시
		 * 학생-수강신청 조인 / 교수-강의 정보 조인 => 두개를 과목번호로 조인 - 4개 테이블 모두 조인
		 */
		List<CourseRegDto> courseregList = null;
		CourseRegDao crDao = new CourseRegDao();
		courseregList = crDao.select수강신청상세정보출력();
		System.out.println("***수강신청상세정보출력***");
		for (CourseRegDto courseRegDto : courseregList) {
			System.out.println(courseRegDto.getCoursereg_no() +", "+ courseRegDto.getCourse_no()
			+", "+ courseRegDto.getCoursename() +", "+ courseRegDto.getTeach_id() +", "+ courseRegDto.getTeachername() 
			+", "+ courseRegDto.getStudent_id()+", "+ courseRegDto.getStudentname() +", "+ courseRegDto.getRegdate());
		}
	}

	private static void select교수별개설과목수() throws Exception { //
		/*
		 * 출력형식: 교수번호,교수이름,개설과목갯수
		 * 쿼리 - 서브쿼리
		 */		
		List<TeacherDto> teacherList = null;
		TeacherDao teDao = new TeacherDao();
		teacherList = teDao.select교수별개설과목수();
		System.out.println("***교수별개설과목수***");

		for (TeacherDto teacherDto : teacherList) {
			System.out.println("교수번호: " + teacherDto.getTeach_id());
			System.out.println("교수이름: " + teacherDto.getName());
			System.out.println("개설과목갯수: "+ teacherDto.getCnt());
			System.out.println("-------------------------------------");
		}
	}

	
	private static void insert수강신청() throws Exception {
		/*
		수강신청시 과목번호 존재하지 않으면 "미등록 과목번호입니다" 출력하고 등록 안한다.
		수강신청시 학생학번 존재하지 않으면 "미등록 학번입니다" 출력하고 등록 안한다.
		신청수가 정원보다 작을 경우에만 등록하고 해당 과목번호의 신청수를 1증가시킨다.
		신청수가 정원과 같으면 "신청정원이 마감되었습니다" 출력하고 등록안한다.
		(10,10,100,'2023-03-01') 정상등록
		(20,20,200,'2023-03-01') 정상등록
		(30,10,300,'2023-03-01') 정상등록
		(40,10,400,'2023-03-01') -> 신청정원이 마감되었습니다
		(40,40,400,'2023-03-01') -> 미등록 과목번호입니다
		(40,30,500,'2023-03-01') -> 미등록 학번입니다
		 */
		System.out.println("** 수강신청등록 **");
		StudentDao stDao = new StudentDao();
		CourseDao coDao = new CourseDao();
		TeacherDao teDao = new TeacherDao();
		CourseRegDao crDao = new CourseRegDao();
		CourseRegDto[] crDtoArr = new CourseRegDto[] {
			new CourseRegDto(10,10,100,"2023-03-01"),
			new CourseRegDto(20,20,200,"2023-03-01"),
			new CourseRegDto(30,10,300,"2023-03-01"),
			new CourseRegDto(40,10,400,"2023-03-01"),
			new CourseRegDto(40,40,400,"2023-03-01"),
			new CourseRegDto(40,30,500,"2023-03-01")
		};
		
		for (CourseRegDto dto : crDtoArr) {
			CourseDto findDto = coDao.selectOne(dto.getCourse_no());
			if (findDto == null) {
				System.out.println("미등록 과목번호입니다");
				continue;
			}
			
			StudentDto findDto1 = stDao.selectOne(dto.getStudent_id()); 
			if (findDto1 == null) {
				System.out.println("미등록 학번입니다");
				continue;
			}
			
			//null이 아니고 값이 정상적이면 crDao에 삽입
			crDao.insert(dto);
			
//			신청수가 정원보다 작을 경우에만 등록하고 해당 과목번호의 신청수를 1증가시킨다.
//			신청수가 정원과 같으면 "신청정원이 마감되었습니다" 출력하고 등록안한다.
			
			int total = coDao.count();
			int reg = crDao.count();
//			CourseDto cdto = coDao.selectOne(dto.getCourse_no());
			if (reg < total) {
				findDto.setCourse_no(findDto.getRegnum() + 1);
				coDao.update(findDto);
			} else {
				System.out.println("신청정원이 마감되었습니다");
				continue;
			}
		}
	}

	private static void insert강의과목() throws Exception {
		/*강의과목개설시 교수번호 존재하지 않는 경우 "미등록 교수번호입니다" 출력하고 등록안한다.
		(10,'자바기본',30,2,0) 정상등록
		(20,'SQL',20,2,0) 정상등록
		(30,'JDBC',50,2,0) -> 미등록 교수번호입니다
		(30,'JDBC',20,2,0) 정상등록
		 */		
		System.out.println("** 강의과목등록 **");
		CourseDao coDao = new CourseDao();
		TeacherDao teDao = new TeacherDao();
		CourseDto[] coDtoArr = new CourseDto[] {
			new CourseDto(10,"자바기본",30,2,0),
			new CourseDto(20,"SQL",20,2,0),
			new CourseDto(30,"JDBC",50,2,0),
			new CourseDto(30,"JDBC",20,2,0)
		};
		
		for (CourseDto dto : coDtoArr) {
			TeacherDto findDto = teDao.selectOne(dto.getTeach_id());
			if(findDto == null) {
				System.out.println("미등록교수번호입니다");
				continue;
    		}
    		coDao.insert(dto);
		}	
	}
	
	
	//#2. 교수등록
	private static void insertTeachers() throws Exception {
		/*교수정보 등록시 교수번호  중복시 "교수번호가 중복됩니다" 출력하고 등록안한다.
		(10,'김교수','수학') 정상등록
		(20,'박교수','화학') 정상등록
		(30,'이교수','컴공') 정상등록
		(30,'최교수','산공') -> 교수번호가 중복됩니다
		(40,'최교수','산공') 정상등록
		 */		
		System.out.println("** 교수등록 **");
		TeacherDao teDao = new TeacherDao();
		TeacherDto[] teDtoArr = new TeacherDto[] {
			new TeacherDto(10,"김교수","수학"),
			new TeacherDto(20,"박교수","화학"),
			new TeacherDto(30,"이교수","컴공"),
			new TeacherDto(30,"최교수","산공"),
			new TeacherDto(40,"최교수","산공")
		};
		
		for (TeacherDto dto : teDtoArr) {
			if((teDao.selectOne(dto.getTeach_id()) != null)) {
				System.out.println("교수번호가 중복됩니다");
				continue;
    		}
			teDao.insert(dto);
		}
	}
	
	
	//#1. 학생등록
	private static void insertStudents() throws Exception {
		/*학생정보등록시 학번 중복시 "학번이 중복됩니다" 출력하고 등록 안한다.
		(100,'홍길동','컴공',3) 정상등록
		(200,'김길동','소공',3) 정상등록
		(300,'박길동','컴공',4) 정상등록
		(200,'이길동','소공',4) -> 학번이 중복됩니다
		(400,'이길동','소공',4) 정상등록
		 */
		System.out.println("** 학생등록 **");
		StudentDao stDao = new StudentDao();
		StudentDto[] stDtoArr = new StudentDto[] {
			new StudentDto(100,"홍길동","컴공",3),
			new StudentDto(200,"김길동","소공",3),
			new StudentDto(300,"박길동","컴공",4),
			new StudentDto(200,"이길동","소공",4),
			new StudentDto(400,"이길동","소공",4)
		};
		
		for (StudentDto dto : stDtoArr) {
			if((stDao.selectOne(dto.getStudent_id()) != null)) {
				System.out.println("학번이 중복됩니다");
				continue;
    		}
			stDao.insert(dto);
			System.out.println("정상등록");
		}
	}
}


