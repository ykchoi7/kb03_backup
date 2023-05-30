package dto;

public class productdto {
	private int pid,price,jego;
	private String pdate;
	private String pname,firm;
	
	public productdto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public productdto(int pid, int price, int jego, String pdate, String pname, String firm) {
		super();
		this.pid = pid;
		this.price = price;
		this.jego = jego;
		this.pdate = pdate;
		this.pname = pname;
		this.firm = firm;
	}


	@Override
	public String toString() {
		return "product [pid=" + pid + ", price=" + price + ", jego=" + jego + ", pdate=" + pdate + ", pname=" + pname
				+ ", firm=" + firm + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getJego() {
		return jego;
	}
	public void setJego(int jego) {
		this.jego = jego;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
}
