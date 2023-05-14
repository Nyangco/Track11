package dto;

public class SnackDto {

	private String p_code, p_name, m_code, m_name;
	private int price;
	
	public SnackDto(String p_code, String p_name, String m_code, String m_name, int price) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.m_code = m_code;
		this.m_name = m_name;
		this.price = price;
	}

	public String getP_code() {
		return p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public String getM_code() {
		return m_code;
	}

	public String getM_name() {
		return m_name;
	}

	public int getPrice() {
		return price;
	}
	
	
	
	
	
}
