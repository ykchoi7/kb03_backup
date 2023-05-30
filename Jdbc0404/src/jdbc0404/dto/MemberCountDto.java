package jdbc0404.dto;

public class MemberCountDto extends MemberDto{
	private int count;

	public MemberCountDto() {
		
	}
	
	public MemberCountDto(int count) {
		super();
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return super.toString() + "count=" + count;
	}
}
