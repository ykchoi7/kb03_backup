package BE_WS_01.dto;

public class SimpleDto {

	private String job;
	private String pageNo;
	private String searchWord;
	
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	@Override
	public String toString() {
		return "job=" + job + ", pageNo=" + pageNo + ", searchWord=" + searchWord;
	}

		
}
