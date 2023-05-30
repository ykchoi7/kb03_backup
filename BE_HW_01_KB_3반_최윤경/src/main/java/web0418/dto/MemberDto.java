package web0418.dto;

public class MemberDto {
	private String id, password, name, intro;
	
	public MemberDto() {
		
	}

	public MemberDto(String id, String password, String name, String intro) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.intro = intro;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "id=" + id + ", password=" + password + ", name=" + name + ", intro=" + intro;
	}
}
