package g_생성자;

public class J0202_dto {
	//사번 성명 부서 직위
	String idNum, name, depart, rank;
	int pay;
	
	J0202_dto (){}

	public J0202_dto(String idNum, String name, String depart, String rank, int pay) {
		super();
		this.idNum = idNum;
		this.name = name;
		this.depart = depart;
		this.rank = rank;
		this.pay = pay;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
	
	
}
