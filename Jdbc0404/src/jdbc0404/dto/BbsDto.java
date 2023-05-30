package jdbc0404.dto;

import java.sql.Date;

public class BbsDto {
	
	public BbsDto() {
		
	}
	
	private String writer_id, title, content;
	private int no;
	private Date date;

	public BbsDto(String writer_id, String title, String content) {
		this.writer_id = writer_id;
		this.title = title;
		this.content = content;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setRegdate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	@Override
	public String toString() {
		return "writer_id=" + writer_id + ", title=" + title + ", content=" + content + ", "
				+ "no=" + no 
				+ ", date=" + date ;
	}
	
}
