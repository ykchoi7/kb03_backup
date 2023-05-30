package jdbc.dto;

import java.sql.Date;

public class OrderDto {
	private int order_no;
	private int client_id;
	private int item_no;
	private int order_quantity;
	private String register_date;
	
	
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "order_no=" + order_no + ", client_id=" + client_id + ", item_no=" + item_no
				+ ", order_quantity=" + order_quantity + ", register_date=" + register_date;
	}
	

}
