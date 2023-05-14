package dto;

public class NewsDto {

	private String no, title, content, reg_id, reg_name, reg_date, update_date;
	private int hit;
	
	//수정용 Dto
	public NewsDto(String no, String title, String content, String reg_id, String reg_date, String update_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.update_date = update_date;
	}

	//이전 - 다음 보기용 Dto
	public NewsDto(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}

	//상세 조회용 Dto
	public NewsDto(String title, String content, String reg_name, String reg_date, String update_date, int hit) {
		super();
		this.title = title;
		this.content = content;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.hit = hit;
	}
	
	//조회용 Dto
	public NewsDto(String no, String title, String reg_name, String reg_date, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.hit = hit;
	}

	//작성용 Dto
	public NewsDto(String no, String title, String content, String reg_id, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}

	//전체 Dto
	public NewsDto(String no, String title, String content, String reg_id, String reg_date, String update_date,
			int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.update_date = update_date;
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

	public String getReg_id() {
		return reg_id;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getUpdate_date() {
		return update_date;
	}
	
	public String getReg_name() {
		return reg_name;
	}

	public int getHit() {
		return hit;
	}
	
	
}
