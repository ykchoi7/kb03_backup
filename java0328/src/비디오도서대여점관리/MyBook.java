package 비디오도서대여점관리;

public class MyBook extends RentProduct {

	private String writer;
	private String page;

	public MyBook(int number, String title, int cost, String status, String writer, String page) {
		super(number, title, cost, status);
		this.writer = writer;
		this.page = page;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return super.toString() + ", writer=" + writer + ", page=" + page;
	}

}
