package web0419.dto;

public class SimpleDto {

	private String mid;
	private String[] singer;
	
	//생성자
	public SimpleDto() {
		
	}
	
	public SimpleDto(String mid, String[] singer) {
		super();
		this.mid = mid;
		this.singer = singer;
	}

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
