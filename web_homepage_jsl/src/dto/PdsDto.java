package dto;

public class PdsDto {
	private String no, title, content, attach, reg_id, reg_date, reg_name;
	private int hit;
		
	public PdsDto(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}

	public PdsDto(String no, String title, String reg_date, String reg_name, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.reg_date = reg_date;
		this.reg_name = reg_name;
		this.hit = hit;
	}

	
	//전부 Dto
	public PdsDto(String no, String title, String content, String attach, String reg_id, String reg_date,
			String reg_name, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.reg_name = reg_name;
		this.hit = hit;
	}

	public PdsDto(String no, String title, String content, String attach, String reg_id, String reg_date) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
	}
	
	public PdsDto(String title, String content, String attach, String reg_date, String reg_name, int hit) {
		super();
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_date = reg_date;
		this.reg_name = reg_name;
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
	public int getHit() {
		return hit;
	}
	
	
	

}
