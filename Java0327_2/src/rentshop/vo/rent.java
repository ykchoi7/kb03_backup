package rentshop.vo;

public class rent {
	private int managenum;
	private String title;
	private int fee;
	private boolean isborrow;
	
	public rent() {
	}
	
	public rent(int managenum,String title,int fee, boolean isborrow) {
		this.managenum = managenum;
		this.title = title;
		this.fee = fee;
		this.isborrow = isborrow;
	}

	@Override
	public String toString() {
		return "managenum=" + managenum + ", title=" + title + ", fee=" + fee + ", isborrow=" + isborrow ;
	}

	public int getManagenum() {
		return managenum;
	}

	public void setManagenum(int managenum) {
		this.managenum = managenum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public boolean isborrow() {
		return isborrow;
	}

	public void setIsborrow(boolean isborrow) {
		this.isborrow = isborrow;
	}
	
}
