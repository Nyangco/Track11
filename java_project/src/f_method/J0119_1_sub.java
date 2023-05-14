package f_method;

public class J0119_1_sub {

	String getName() {
		String str = "홍길동";
		return str;
	}
	
	int getPoint() {
		return 100;
	}
	
	String getKor() {
		return "90";
	}
	
	int plusNum(int k) {
		k += 80;
		return k;
	}
	
	int getEng() {
		return 80;
	}
	
	boolean getTrue() {
		return true;
	}
	
	String getNoodle(int k) {
		String size = "";
		if(k<0) size = "오입력";
		else if(k<=100) size = "소";
		else if(k<=200) size = "중";
		else size = "대";
		return size;
	}
	
	boolean xor(boolean a, boolean b) {
		boolean c = true;
		if(a==b) c=true;
		if(a!=b) c=false;
		return c;
	}
	
	String getPass(int score) {
		String result = "";
		if(score>=50 && score<=100) result = "pass";
		else if(score>=0 && score<=49) result = "fail";
		else result = "오입력";
		return result;
	}
	
}
