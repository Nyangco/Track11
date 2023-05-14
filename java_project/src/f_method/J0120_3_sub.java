package f_method;

public class J0120_3_sub {

	int getTotal(int[] num) {
		int total = 0;
		for(int k = 0; k<num.length; k++) total+=num[k];
		return total;
	}
	
	int getAve(int[] num1, int num2) {
		int total = 0;
		for(int k=0; k <num1.length; k++) total += num1[k];
		return total/3;
	}
	
	int getAve(int[] num1) {
		int total = 0;
		for(int k=0; k <num1.length; k++) total += num1[k];
		return total/num1.length;
	}
}
