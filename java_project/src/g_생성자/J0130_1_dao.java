package g_생성자;

public class J0130_1_dao {
	//계산을 위한 class의 default값은 dao이다.
	
	//총합을 구하는 method
	int getTotal (int a, int b, int c) {return a+b+c;}
	
	int getTotal (J0130_student stu) {
		return stu.getEng()+stu.getKor()+stu.getMat();
	}
	
	//평균을 구하는 method
	int getAve(int total, int subCount) {return total/subCount;}
	
	int getAve(J0130_student stu) {
		int ave = stu.getTotal()/3;
		return ave;
	}

	void getSetTotal(J0130_student stu) {
		// TODO Auto-generated method stub
		int total = stu.getKor()+stu.getEng()+stu.getMat();
		stu.setTotal(total);
		
		//getter method랑 field를 직접 지정하는것의 차이?
	}
	
	void getSetAve(J0130_student stu) {
		int ave = stu.getTotal()/3;
		stu.setAve(ave);
	}

	
}
