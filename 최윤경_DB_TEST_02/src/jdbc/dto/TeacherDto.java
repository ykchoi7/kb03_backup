package jdbc.dto;

public class TeacherDto {
	
	public TeacherDto() {
		
	}
	
	private int teach_id;
	private String name;
	private String major;
	private int cnt;

	public TeacherDto(int teach_id, String name, String major) {
		this.teach_id = teach_id;
		this.name = name;
		this.major = major;
	}

	public int getTeach_id() {
		return teach_id;
	}

	public void setTeach_id(int teach_id) {
		this.teach_id = teach_id;
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

	@Override
	public String toString() {
		return "teach_id=" + teach_id + ", name=" + name + ", major=" + major + ", cnt=" + cnt;
	}

	
	public TeacherDto(int cnt) {
		this.cnt = cnt;
	}
	
	public void setCnt(int cnt) {
		this.cnt = cnt;	
	}

	public int getCnt() {
		return cnt;
	}

	
}
