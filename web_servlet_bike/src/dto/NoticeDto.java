package dto;

public class NoticeDto {

	private String no, reg_id, title, content, attach, reg_date, update_date, update_id, reg_name;
	private int hit;
	
	//View 앞 뒤 찾아오기용
	public NoticeDto(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}

	//전체
	public NoticeDto(String no, String reg_id, String title, String content, String attach, String reg_date,
			String update_date, String update_id, String reg_name, int hit) {
		super();
		this.no = no;
		this.reg_id = reg_id;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.update_id = update_id;
		this.reg_name = reg_name;
		this.hit = hit;
	}

	public String getNo() {
		return no;
	}

	public String getReg_id() {
		return reg_id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getAttach() {
		return attach;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public String getUpdate_id() {
		return update_id;
	}

	public String getReg_name() {
		return reg_name;
	}

	public int getHit() {
		return hit;
	}
	
	

}
