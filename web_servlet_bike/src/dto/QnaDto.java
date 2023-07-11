package dto;

public class QnaDto {

	private String no,reg_id,reg_name,reg_date,content,reply,s_count;

	public QnaDto(String no, String reg_id, String reg_name, String reg_date, String content, String reply,
			String s_count) {
		super();
		this.no = no;
		this.reg_id = reg_id;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.content = content;
		this.reply = reply;
		this.s_count = s_count;
	}

	public QnaDto(String no, String reg_id, String reg_name, String reg_date, String content, String reply) {
		super();
		this.no = no;
		this.reg_id = reg_id;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.content = content;
		this.reply = reply;
	}

	public String getS_count() {
		return s_count;
	}

	public String getNo() {
		return no;
	}

	public String getReg_id() {
		return reg_id;
	}

	public String getReg_name() {
		return reg_name;
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
