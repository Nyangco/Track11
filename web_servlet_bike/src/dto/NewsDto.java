package dto;

public class NewsDto {

	private String no, title, content, attach, reg_id, reg_date, reg_name, update_id, update_date, update_name;
	private int hit;
	
	//통
	public NewsDto(String no, String title, String content, String attach, String reg_id, String reg_date,
			String reg_name, String update_id, String update_date, String update_name, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.reg_name = reg_name;
		this.update_id = update_id;
		this.update_date = update_date;
		this.update_name = update_name;
		this.hit = hit;
	}

	public String getNo() {
		return no;
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

	public String getReg_id() {
		return reg_id;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getReg_name() {
		return reg_name;
	}

	public String getUpdate_id() {
		return update_id;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public String getUpdate_name() {
		return update_name;
	}

	public int getHit() {
		return hit;
	}
	
	
}
