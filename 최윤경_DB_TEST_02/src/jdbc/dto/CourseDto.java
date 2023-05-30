package jdbc.dto;

public class CourseDto {
	
	public CourseDto() {
		
	}
	
	private int course_no;
	private String name;
	private int teach_id;
	private int total;
	private int regnum;
	private String teachername;

	public CourseDto(int course_no, String name, int teach_id, int total, int regnum) {
		this.course_no = course_no;
		this.name = name;
		this.teach_id = teach_id;
		this.total = total;
		this.regnum = regnum;
	}

	public int getCourse_no() {
		return course_no;
	}

	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeach_id() {
		return teach_id;
	}

	public void setTeach_id(int teach_id) {
		this.teach_id = teach_id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRegnum() {
		return regnum;
	}

	public void setRegnum(int regnum) {
		this.regnum = regnum;
	}

	@Override
	public String toString() {
		return "course_no=" + course_no + ", name=" + name + ", teach_id=" + teach_id + ", total=" + total
				+ ", regnum=" + regnum + ", " + teachername ;
	}

	public void setTeacher_name(String teachername) {
		this.teachername = teachername;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

}
