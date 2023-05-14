package d_반복문;

import java.util.Scanner;

public class J0112_while {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int num1 = 0, num2 = 0;
		
		num1 = 1;
		while(num1<=9) {
			System.out.println("2 * "+num1+" = "+(num1*2));
			num1++;
		}
		
//		
//		while(num1<=5) {
//			num2++;
//			num1++;
//		}
//	
//		System.out.println(num2);
//	
//		while(true) {
//			System.out.print("수 입력 : ");
//			num1 = sc.nextInt();
//			if (num1 == 0) break;
//			num2 += num1;
//		}
//		System.out.println(num2);
	}
	
}
