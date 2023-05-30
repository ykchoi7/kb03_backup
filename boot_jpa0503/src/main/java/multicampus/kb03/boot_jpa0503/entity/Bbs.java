package multicampus.kb03.boot_jpa0503.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Bbs {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bbs_SEQ")
    @SequenceGenerator(sequenceName = "bbs_SEQ", allocationSize = 1, name = "bbs_SEQ")
	
	private int no;
	private String title, writer_id, content;
	private Date regdate;
	
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
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
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
		return "Bbs [no=" + no + ", title=" + title + ", writer_id=" + writer_id + ", content=" + content + ", regdate="
				+ regdate + "]";
	}
	
}
