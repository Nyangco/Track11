package d_반복문;

import java.util.Scanner;

public class J0112_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = 0, num2 = 0, num3=0;
		
		System.out.print("몇부터?");
		num1 = sc.nextInt();
		System.out.print("몇까지?");
		num2 = sc.nextInt();
		
		if(num1>num2) {
			num3 = num1;
			num1 = num2;
			num2 = num3;
		}
		
		num3 = 0;
		for(int k = num1; k <= num2; k++) {
			num3 += k;
			System.out.println(k+"까지의 합계 : "+num3);
		}
		System.out.println("총 합 : "+num3);
	}
}
