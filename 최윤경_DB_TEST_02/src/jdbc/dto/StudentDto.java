package jdbc.dto;

public class StudentDto {
	
	public StudentDto() {
		
	}

	private int student_id;
	private String name;
	private String major;
	private int grade;
	private int cnt;

	public StudentDto(int student_id, String name, String major, int grade) {
		this.student_id = student_id;
		this.name = name;
		this.major = major;
		this.grade = grade;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "student_id=" + student_id + ", name=" + name + ", major=" + major + ", grade=" + grade + ", cnt=" + cnt;
	}

	
	public StudentDto(int cnt) {
		this.cnt = cnt;
	}
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getCnt() {
		return cnt;
	}
	
}
