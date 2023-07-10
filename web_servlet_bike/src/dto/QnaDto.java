package dto;

public class QnaDto {

	private String no,title,reg_id,reg_date,content,reply;

	public QnaDto(String no, String title, String reg_id, String reg_date, String content, String reply) {
		super();
		this.no = no;
		this.title = title;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.content = content;
		this.reply = reply;
	}

	public String getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public String getReg_id() {
		return reg_id;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getContent() {
		return content;
	}

	public String getReply() {
		return reply;
	}
	
	
}
