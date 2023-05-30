package dto;
import java.util.Date;

public class orderingdto {
	private int ornum,or_uid,or_pid,or_amount;
	private Date ordate;
	public int getOrnum() {
		return ornum;
	}
	public void setOrnum(int ornum) {
		this.ornum = ornum;
	}
	public int getOr_uid() {
		return or_uid;
	}
	public void setOr_uid(int or_uid) {
		this.or_uid = or_uid;
	}
	public int getOr_pid() {
		return or_pid;
	}
	public void setOr_pid(int or_pid) {
		this.or_pid = or_pid;
	}
	public int getOr_amount() {
		return or_amount;
	}
	public void setOr_amount(int or_amount) {
		this.or_amount = or_amount;
	}
	public Date getOrdate() {
		return ordate;
	}
	public void setOrdate(Date ordate) {
		this.ordate = ordate;
	}
	@Override
	public String toString() {
		return "ordering [ornum=" + ornum + ", or_uid=" + or_uid + ", or_pid=" + or_pid + ", or_amount=" + or_amount
				+ ", ordate=" + ordate + "]";
	}
	
}
