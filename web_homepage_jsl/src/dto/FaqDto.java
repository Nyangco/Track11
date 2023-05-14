package dto;

public class FaqDto {

	private String no, title, id, reg_date, content, name, up_date;

	//작성용
	public FaqDto(String no, String title, String id, String reg_date, String content) {
		super();
		this.no = no;
		this.title = title;
		this.id = id;
		this.reg_date = reg_date;
		this.content = content;
	}

	//조회용
	public FaqDto(String no, String title, String id, String reg_date, String content, String name, String up_date) {
		super();
		this.no = no;
		this.title = title;
		this.id = id;
		this.reg_date = reg_date;
		this.content = content;
		this.name = name;
		this.up_date = up_date;
	}

	public String getUp_date() {
		return up_date;
	}

	public String getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public String getId() {
		return id;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getContent() {
		return content;
	}
	
	public String getName() {
		return name;
	}
	
	
}
