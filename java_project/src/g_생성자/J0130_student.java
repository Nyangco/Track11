package g_생성자;

public class J0130_student {
	J0130_1_dao sub = new J0130_1_dao();	

	String name;
	int kor, eng, mat, total, ave;
	
	J0130_student (){}
	
	
	
	public J0130_student(String name, int kor, int eng, int mat, int total, int ave) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = total;
		this.ave = ave;
	}



	J0130_student (String name, int kor, int eng, int mat){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = sub.getTotal(this.kor, this.eng, this.mat);
		this.ave = sub.getAve(this.total, 3);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAve() {
		return ave;
	}

	public void setAve(int ave) {
		this.ave = ave;
	}
	
	
	
		
}
