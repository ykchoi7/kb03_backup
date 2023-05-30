
public class UserDto {
	private int user_seq;
	private String name, email, phone;
	private boolean is_sleep;
	
	public UserDto() {
		
	}
	
	public void UerDto(int user_seq, String name, String email, String phone, boolean is_sleep) {
		this.user_seq = user_seq;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.is_sleep = is_sleep;
	}
	

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean getIs_sleep() {
		return is_sleep;
	}

	public void setIs_sleep(boolean is_sleep) {
		this.is_sleep = is_sleep;
	}

	@Override
	public String toString() {
		return "user_seq=" + user_seq + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", is_sleep=" + is_sleep;
	}

}
