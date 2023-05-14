package b_if;

public class J0105_1 {
	public static void main(String[] args) {
		int a=10, b=5;
		if(a%b==0) {
			System.out.println("true");
		}
		if(a!=b && a>b) {
			System.out.println("2 true");	
		}
		if(a==b || a>b) {
			System.out.println("3 true");
		}
		if(a>b) {
			if(a!=b) {
				System.out.println("4 true");
			}
		}
		if(a>b&&a!=b) {
			System.out.println("5 true");
		}
		
		System.out.println("끝");
	}
	
}
