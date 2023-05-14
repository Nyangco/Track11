package g_생성자;

public class J0203_연석모_dto {

	String name, pass;
	int kor, eng, mat;
	double ave;
	
	public J0203_연석모_dto(String name, String pass, int kor, int eng, int mat, double ave) {
		super();
		this.name = name;
		this.pass = pass;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.ave = ave;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public double getAve() {
		return ave;
	}

	public void setAve(double ave) {
		this.ave = ave;
	}

	
	
	
	
	
}
