package dto;
import java.util.Date;

public class incomedto {
	private int inum,inpid,inmount;
	private Date indate;
	public int getInum() {
		return inum;
	}
	public void setInum(int inum) {
		this.inum = inum;
	}
	public int getInpid() {
		return inpid;
	}
	public void setInpid(int inpid) {
		this.inpid = inpid;
	}
	public int getInmount() {
		return inmount;
	}
	public void setInmount(int inmount) {
		this.inmount = inmount;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "income [inum=" + inum + ", inpid=" + inpid + ", inmount=" + inmount + ", indate=" + indate + "]";
	}
	
}
