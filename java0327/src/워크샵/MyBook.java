package 워크샵;

public class MyBook {

	private String title;
	private int isbn;
	private int price;
	private String chulpansa;

	public MyBook(String title, int isbn, int price, String chulpansa) {
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.chulpansa = chulpansa;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getChulpansa() {
		return chulpansa;
	}

	public void setChulpansa(String chulpansa) {
		this.chulpansa = chulpansa;
	}

	@Override
	public String toString() {
		return "title=" + title + ", isbn=" + isbn + ", price=" + price + ", chulpansa=" + chulpansa;
	}
	
	

}
