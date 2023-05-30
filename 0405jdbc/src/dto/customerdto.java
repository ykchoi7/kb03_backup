package dto;

import java.util.Date;

public class customerdto {
	private int userid;
	private String pdate;
	private String name,phone;
	
	public customerdto() {
	}
	
	public customerdto(int userid, String pdate, String name, String phone) {
		super();
		this.userid = userid;
		this.pdate = pdate;
		this.name = name;
		this.phone = phone;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "customer [userid=" + userid + ", pdate=" + pdate + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
