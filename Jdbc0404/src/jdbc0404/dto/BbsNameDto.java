package jdbc0404.dto;

import java.sql.Date;

public class BbsNameDto {
	private int no;
	private String writer_id;
	private String title;
	private String content;
	private Date date;
	private Object writer_name;

	public BbsNameDto() {
		
	}
	
	public BbsNameDto(int no, String writer_id, String title, String content, Date date, String writer_name) {
		this.no = no;
		this.writer_id = writer_id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.writer_name = writer_name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Object getWriter_name() {
		return writer_name;
	}

	public void setWriter_name(Object writer_name) {
		this.writer_name = writer_name;
	}

	@Override
	public String toString() {
		return "no=" + no + ", writer_id=" + writer_id + ", title=" + title + ", content=" + content
				+ ", date=" + date + ", writer_name=" + writer_name;
	}

}
