package rentshop.vo;
public class book extends rent{
	private String writter;
	private int page;

	public book() {
	}
	
	public book(int managenum,String writter, String title, int page, int fee, boolean isborrow) {
		super(managenum,title,fee,isborrow);
		this.writter = writter;
		this.page = page;
	}

	public String getWritter() {
		return writter;
	}

	public void setWritter(String writter) {
		this.writter = writter;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return super.toString()+", writter=" + writter + ", page=" + page + "]";
	}
	
}
