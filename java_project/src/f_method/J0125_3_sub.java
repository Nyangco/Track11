package f_method;

public class J0125_3_sub {

	int getPay(int a, String b) {
		if(b.equals("1")) a+=100000;
		else if(b.equals("2")) a+=200000;
		return a;
	}
}
