package dto;

public class ProductDto {

	private String p_no, p_name, p_content, p_tag, attach, p_size_w, p_size_l, p_size_h, p_weight, price, p_level, c_name, reg_date, reg_id, update_id, update_date;
	private int hit;
	
	public ProductDto(String p_no, String p_name, String p_content, String p_tag, String attach, String p_size_w,
			String p_size_l, String p_size_h, String p_weight, String price, String p_level, String c_name, int hit,
			String reg_date, String reg_id, String update_id, String update_date) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_content = p_content;
		this.p_tag = p_tag;
		this.attach = attach;
		this.p_size_w = p_size_w;
		this.p_size_l = p_size_l;
		this.p_size_h = p_size_h;
		this.p_weight = p_weight;
		this.price = price;
		this.p_level = p_level;
		this.c_name = c_name;
		this.hit = hit;
		this.reg_date = reg_date;
		this.reg_id = reg_id;
		this.update_id = update_id;
		this.update_date = update_date;
	}

	public String getP_no() {
		return p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public String getP_content() {
		return p_content;
	}

	public String getP_tag() {
		return p_tag;
	}

	public String getAttach() {
		return attach;
	}

	public String getP_size_w() {
		return p_size_w;
	}

	public String getP_size_l() {
		return p_size_l;
	}

	public String getP_size_h() {
		return p_size_h;
	}

	public String getP_weight() {
		return p_weight;
	}

	public String getPrice() {
		return price;
	}

	public String getP_level() {
		return p_level;
	}

	public String getC_name() {
		return c_name;
	}

	public int getHit() {
		return hit;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getReg_id() {
		return reg_id;
	}

	public String getUpdate_id() {
		return update_id;
	}

	public String getUpdate_date() {
		return update_date;
	}
	
	
	
}
