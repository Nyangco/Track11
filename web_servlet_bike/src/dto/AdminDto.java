package dto;

public class AdminDto {

	private String id, sLevel, name, area, address, mobile_1, mobile_2, mobile_3, gender, hobby_travel, hobby_reading, hobby_sports;
	private String reg_date, update_date, last_login_date, exit_date, email;
	private int pwLen;
	
	public AdminDto(String id, String sLevel, String name, String area, String address, String mobile_1,
			String mobile_2, String mobile_3, String gender, String hobby_travel, String hobby_reading,
			String hobby_sports, String reg_date, String update_date, String last_login_date, String exit_date,
			String email, int pwLen) {
		super();
		this.id = id;
		this.sLevel = sLevel;
		this.name = name;
		this.area = area;
		this.address = address;
		this.mobile_1 = mobile_1;
		this.mobile_2 = mobile_2;
		this.mobile_3 = mobile_3;
		this.gender = gender;
		this.hobby_travel = hobby_travel;
		this.hobby_reading = hobby_reading;
		this.hobby_sports = hobby_sports;
		this.reg_date = reg_date;
		this.update_date = update_date;
		this.last_login_date = last_login_date;
		this.exit_date = exit_date;
		this.email = email;
		this.pwLen = pwLen;
	}

	public String getId() {
		return id;
	}

	public String getsLevel() {
		return sLevel;
	}

	public String getName() {
		return name;
	}

	public String getArea() {
		return area;
	}

	public String getAddress() {
		return address;
	}

	public String getMobile_1() {
		return mobile_1;
	}

	public String getMobile_2() {
		return mobile_2;
	}

	public String getMobile_3() {
		return mobile_3;
	}

	public String getGender() {
		return gender;
	}

	public String getHobby_travel() {
		return hobby_travel;
	}

	public String getHobby_reading() {
		return hobby_reading;
	}

	public String getHobby_sports() {
		return hobby_sports;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public String getLast_login_date() {
		return last_login_date;
	}

	public String getExit_date() {
		return exit_date;
	}

	public String getEmail() {
		return email;
	}

	public int getPwLen() {
		return pwLen;
	}
	
	
}
