package d_반복문;

import java.util.Scanner;

public class J0111_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int j = 0;
		
		System.out.print("몇 단? : ");
		j = sc.nextInt();
		
		for(int k=0;k<5;k++) {
			System.out.println("K : "+k);
		}
		//반복문의 변수값은 미리 선언하지 말고 for 선언문 안쪽에서 선언하자!
		
		for(int i=1;i<=9;i++) {
			System.out.println(j+" * "+i+" = "+i*j);
			
		}
	}
}
