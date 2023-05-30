package jdbc.dto;

public class CourseRegDto {
	
	public CourseRegDto() {
	}
	
	private int coursereg_no;
	private int course_no;
	private int student_id;
	private String regdate;
	private String coursename;
	private String teachername;
	private String studentname;
	private int teach_id;

	public CourseRegDto(int coursereg_no, int course_no, int student_id, String regdate) {
		this.coursereg_no = coursereg_no;
		this.course_no = course_no;
		this.student_id = student_id;
		this.regdate = regdate;
	}

	public int getCoursereg_no() {
		return coursereg_no;
	}

	public void setCoursereg_no(int coursereg_no) {
		this.coursereg_no = coursereg_no;
	}

	public int getCourse_no() {
		return course_no;
	}

	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "coursereg_no=" + coursereg_no + ", course_no=" + course_no + ", student_id=" + student_id
				+ ", regdate=" + regdate + ", coursename=" + coursename + ", teachername=" + teachername
				+ ", studentname=" + studentname + ", teach_id=" + teach_id;
	}
	
	public CourseRegDto(String coursename, String teachername, String studentname, int teach_id) {
		this.coursename = coursename;
		this.teachername = teachername;
		this.studentname = studentname;
		this.teach_id = teach_id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public int getTeach_id() {
		return teach_id;
	}

	public void setTeach_id(int teach_id) {
		this.teach_id = teach_id;
	}
	
}
