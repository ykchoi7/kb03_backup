package rentshop.vo;


public class video extends rent {
	private String firm;
	private int time;

	public video() {
	}
	
	public video(int managenum,String firm, String title, int time, int fee, boolean isborrow) {
		super(managenum,title,fee,isborrow);
		this.firm = firm;
		this.time = time;
	}

	@Override
	public String toString() {
		return super.toString()+", firm=" + firm + ", time=" + time ;
	}

	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
