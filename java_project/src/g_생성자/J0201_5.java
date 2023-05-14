package g_생성자;

import java.util.Scanner;

public class J0201_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[3];
		
		for(int k=0; k<num.length; k++) {
			System.out.print("원하는 숫자를 입력");
			num[k]=sc.nextInt();
		}
		
		for(int k=0; k<num.length; k++) {
			System.out.println(num[k]);
		}
	}
}
