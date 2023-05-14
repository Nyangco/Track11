package g_생성자;

public class J0206_2_dto {
	String id, name, result;
	int kor, eng, mat;
	double ave;
	
	public J0206_2_dto(String id, String name, String result, int kor, int eng, int mat, double ave) {
		super();
		this.id = id;
		this.name = name;
		this.result = result;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.ave = ave;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
