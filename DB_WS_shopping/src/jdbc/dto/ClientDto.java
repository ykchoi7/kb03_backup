package jdbc.dto;

import java.sql.Date;

public class ClientDto {
	private int client_id;
	private String name;
	private String tel;
	private String register_date;
	
	
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "client_id=" + client_id + ", name=" + name + ", tel=" + tel + ", register_date="
				+ register_date;
	}
	
}
