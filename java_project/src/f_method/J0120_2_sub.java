package f_method;

public class J0120_2_sub {
	int getTotal(int a, int b, int c) { return a+b+c;}
	int getTotal(int a, int b, String c) { return a+b+Integer.parseInt(c);}
	int getTotal(int a, String b, String c) { return a+Integer.parseInt(b)+Integer.parseInt(c);}
	int getTotal(int a, String b) { return a+Integer.parseInt(b);}
}
