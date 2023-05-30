package 비디오도서대여점관리;

/** 비디오, 도서의 부모클래스 */
public class RentProduct {

	private int number;
	private String title;
	private int cost;
	private String status;

	public RentProduct(int number, String title, int cost, String status) {
		this.number = number;
		this.title = title;
		this.cost = cost;
		this.status = status;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "number=" + number + ", title=" + title + ", cost=" + cost + ", status=" + status;
	}
	
}
