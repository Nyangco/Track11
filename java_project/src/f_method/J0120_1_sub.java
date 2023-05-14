package f_method;

public class J0120_1_sub {

	int getTotal_1 (int num1, int num2) { return num1+num2;}
	int getTotal_2 (int num1, int num2, int num3) {return num1+num2+num3;}
	String getTotal_3 (int num1, int num2) { return Integer.toString(num1+num2);}
	int getAve_1 (int num1, int num2) {return num1/num2;}
	int getAve_2 (String num1, int num2) { return Integer.parseInt(num1)/num2;}
	String getAve_3 (int num1, String num2) {
		int numAve = num1/Integer.parseInt(num2);
		return Integer.toString(numAve);
	}
	String getAve_4 (String num1, String num2) {
		int numAve = Integer.parseInt(num1)/Integer.parseInt(num2);
		return Integer.toString(numAve);
	}
	int getTotal_4 (int a, String b, int c, String d) {return a+Integer.parseInt(b)+c+Integer.parseInt(d);}
	double getAve_5 (int a, String b) {return (double)(a/Integer.parseInt(b));}
}
