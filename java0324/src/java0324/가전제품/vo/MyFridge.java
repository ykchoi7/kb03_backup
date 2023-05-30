package java0324.가전제품.vo;

public class MyFridge extends MyGajeon{

	private int door;
	private int temp;

	public MyFridge(String madeby, int date, int door, int temp) {
		super(madeby, date);
		this.door = door;
		this.temp = temp;
		
		
	}

	public int getDoor() {
		return door;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return super.toString() + ", door=" + door + ", temp=" + temp;
	}

}
