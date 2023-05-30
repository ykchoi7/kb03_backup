package jdbc.dto;

import java.sql.Date;

public class StorageDto {
	private int storage_no;
	private int item_no;
	private int quantity;
	private String register_date;
	
	
	public int getStorage_no() {
		return storage_no;
	}
	public void setStorage_no(int storage_no) {
		this.storage_no = storage_no;
	}
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "storage_no=" + storage_no + ", item_no=" + item_no + ", quantity=" + quantity
				+ ", register_date=" + register_date;
	}	
	
}
