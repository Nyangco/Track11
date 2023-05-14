package dto;

public class QnaDto {

	private String no, reply, id, title, content, attach, reg_date, name, up_date;
	private int hit;

	//이전 이후 Dto
	public QnaDto(String no, String title) {
		super();
		this.no = no;
		this.title = title;
	}

	//전체 사용하는 Dto
	public QnaDto(String no, String reply, String id, String title, String content, String attach, String reg_date,
			String name, String up_date, int hit) {
		super();
		this.no = no;
		this.reply = reply;
		this.id = id;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_date = reg_date;
		this.name = name;
		this.up_date = up_date;
		this.hit = hit;
	}

	//수정용 Dto
	public QnaDto(String title, String content, String attach, String reg_date, String name) {
		super();
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_date = reg_date;
		this.name = name;
	}

	//상세 조회용 Dto
	public QnaDto(String reply, String id, String title, String content, String reg_date, String name, String up_date,
			int hit) {
		super();
		this.reply = reply;
		this.id = id;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		this.name = name;
		this.up_date = up_date;
		this.hit = hit;
	}

	//리스트 목록 조회용 Dto
	public QnaDto(String no, String reply, String name, String title, String reg_date, int hit) {
		super();
		this.no = no;
		this.reply = reply;
		this.name = name;
		this.title = title;
		this.reg_date = reg_date;
		this.hit = hit;
	}


	//저장용 Dto
	public QnaDto(String no, String id, String title, String content, String attach, String reg_date) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.reg_date = reg_date;
	}

	public String getNo() {
		return no;
	}

	public String getReply() {
		return reply;
	}

	public String getId() {
		return id;
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

	public String getUp_date() {
		return up_date;
	}

	public int getHit() {
		return hit;
	}
	
	public String getName() {
		return name;
	}
}
