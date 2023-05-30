package 비디오도서대여점관리;

public class MyVideo extends RentProduct {

	private String company;
	private String time;

	public MyVideo(int number, String title, int cost, String status, String company, String time) {
		super(number, title, cost, status);
		this.company = company;
		this.time = time;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return super.toString() + ", company=" + company + ", time=" + time;
	}
	
	

}
