package web0417.dto;

public class SimpleDto {

	private String mid;
	private String[] singer;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String[] getSinger() {
		return singer;
	}
	public void setSinger(String[] singer2) {
		this.singer = singer2;
	}
	@Override
	public String toString() {
		return "mid=" + mid + ", singer=" + singer;
	}
		
}
