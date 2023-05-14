package g_생성자;

public class J0125_1_dto {
	String name;
	int kor;
	double ave;
//	클래스 전역에 영향을 끼치는 전역변수
//	모든 지역에서 공통으로 변수를 사용하기 위함
	
	
//	DTO 클래스의 예 - Data Transfer Object 데이터를 전달하는 class -> Value Object 라고도 사용.
	
	int getKor() {
//	값을 가져오는 method -> get ter 
		return kor;
	}
	
	String getName() {
		return name;
	}
	
	double getAve() {
		return ave;
	}

	void setKor(int kor) {
//	값을 설정하는 method -> set ter
		this.kor = kor;
		return;
	}
	
	
	void setName(String name) {
		this.name = name; 
	}
	
	void setAve(double ave) {
		this.ave = ave;
	}
	
	int getPoint_1() {
		int kor = 100;
//		한 method 지역 안에서만 영향을 끼치는 지역변수
		this.kor = 300;
//		지역 변수와 전역 변수가 중복될 때 구분해주기 위한 예약어 ==> this.
		return 0;
	}
}
