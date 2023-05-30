package BE_WS_01.dto;

import java.util.Arrays;

public class SimpleDto2 {

	private String name;
	private String email;
	private String gender;
	private String[] hobby;
	private String favorite;
	private String desc;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby2) {
		this.hobby = hobby2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	@Override
	public String toString() {
		return "name=" + name + ", email=" + email + ", gender=" + gender + ", hobby=" + Arrays.toString(hobby)
				+ ", favorite=" + favorite + ", desc=" + desc;
	}
	
	
}
