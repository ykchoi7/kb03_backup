package java0324.가전제품.vo;

public class MyGajeon {

	private String madeby;
	private int date;

	public MyGajeon(String madeby, int date) {
		this.madeby = madeby;
		this.date = date;
	}

	public String getMadeby() {
		return madeby;
	}

	public void setMadeby(String madeby) {
		this.madeby = madeby;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "madeby=" + madeby + ", date=" + date;
	}

}
