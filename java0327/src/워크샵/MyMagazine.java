package 워크샵;

public class MyMagazine extends MyBook {

	private int term;
	private int number;

	public MyMagazine(String title, int isbn, int price, String chulpansa, int term, int number) {
		super(title, isbn, price, chulpansa);
		this.term = term;
		this.number = number;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return super.toString() + ", term=" + term + ", number=" + number;
	}

}
