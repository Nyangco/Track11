package e_배열;

public class J0113_2 {

	public static void main(String[] args) {
		int[] aa = {10,20,30,40};
		String[] bb = {"aaa","bbb","ccc"};
		int total = 0;
		
		for(int k=0;k<aa.length;k++) {
			total += aa[k];
			System.out.println(aa[k]);
		}
		System.out.println(total);
		System.out.println("====================================");
		
		for(int k = 0; k<aa.length; k++) {
			aa[k]+=100;
			System.out.println(aa[k]);
		}
	}
}
