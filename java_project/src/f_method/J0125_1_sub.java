package f_method;

public class J0125_1_sub {
	
	int getTotal(String a, int b) {
		return Integer.parseInt(a)+b; 
	}

	int getTotal(int a, String b) {
		int result = a+Integer.parseInt(b);
		return  result;
	}
	
	int getTotal(int arr[]) {
		int result = 0;
		for(int k=0; k<arr.length; k++) {
			result+=arr[k];
		}
		return result;
	}
	
	int[] getTotal(int a, int b) {
		int arr[] = new int[2];
		arr[0]= a+b;
		arr[1]= arr[0]/2;
		return arr;
	}
		
	String[] getTotal(int a, int b, int c) {
		String[] arr = new String[2];
		arr[0] = Integer.toString(a+b+c);
		arr[1] = String.valueOf((a+b+c)/3);
		return arr;
	}
	
	int getTotal(int a[], String b[]) {
		int sum = 0;
		for(int k=0; k<a.length; k++) sum += a[k];
		for(int k=0; k<b.length; k++) sum += Integer.parseInt(b[k]);
		return sum;
	}
	
	
	
}
