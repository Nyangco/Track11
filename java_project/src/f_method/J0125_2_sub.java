package f_method;

public class J0125_2_sub {

	int getTotal(int a, int b, int c) {
		return a+b+c;
	}
	
	double getAve(int total, int a) {
		return (double)total/a;
	}
	
	String getResult(double a) {
		if(a>=90) return "수";
		else if(a>=80) return "우";
		else if(a>=70) return "미";
		else if(a>=60) return "양";
		else return "가";		
	}
}
