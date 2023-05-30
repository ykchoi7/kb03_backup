package dto;

import java.sql.Date;

public class BbsDto {
	private int no;
	private String title, writer, content;
	private Date regdate;
	
	public BbsDto() {
	}

	public void BbsDto(Integer no, String title, String writer, String content, Date regdate) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content;
	}
	
}
