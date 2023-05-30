package jdbc.dto;

import java.sql.Date;

public class ItemDto {
	private static int item_no;
	private static String item_name;
	private static String company;
	private static int price;
	private static int stock;
	private static String register_date;
	
	public static int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public static String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public static String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public static int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public static String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "item_no=" + item_no + ", item_name=" + item_name + ", company=" + company + ", price=" + price
				+ ", stock=" + stock + ", register_date=" + register_date;
	}
	
}
