package f_method;

public class J0119_2_sub {

	String getGubun(String num) {
		int num1 = 0;
		num1 = Integer.parseInt(num) - 300;
		String num2 = Integer.toString(num1);
		return num2;			
	}
	
	String getTotal(int num1, String num2) {
		String sum = "";
		sum = Integer.toString(num1 + Integer.parseInt(num2));
		return sum;
	}
}
