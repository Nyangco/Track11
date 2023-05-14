package d_반복문;

import java.util.Scanner;

public class J0112_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int que1 = 0, que2 = 0, que3 = 0, que4 = 0;
		int start = 0, end = 0;
		double que5 = 0, que6 = 0;
		double ans1 = 0;
	
		System.out.print("몇단부터?");
		start = sc.nextInt();
		System.out.print("몇단까지?");
		end = sc.nextInt();
		
		for(int p = start; p <= end; p++) {
			for(int q = 1; q <= 9 ; q++) System.out.println(p+" * "+q+" = "+(p*q));
		}
		
		
//		System.out.println("2진수의 10진수 변환기 입니다.");
//		System.out.print("2진수의 자리수를 입력하시오");
//		que5 = sc.nextInt();
//		
//		for(double o = 0; o < que5; o++) {
//			System.out.print("2진수를 뒷자리부터 입력하세요");
//			que6 = sc.nextInt();
//			if(que6 == 1) ans1+=(que6*Math.pow(2,o));
//		}
//		System.out.println(ans1);
		
		
		
		
		
//		for(int m = start; m<=end; m++) {
//			for(int n = 1; n<=9; n++) {
//				System.out.println(m+" * "+n+" = "+m*n);
//			}
//		}
		
		
		
		
		
//		System.out.print("첫 정수를 입력하시오");
//		que1 = sc.nextInt();
//		System.out.print("두번째 정수를 입력하시오");
//		que2 = sc.nextInt();
//		System.out.print("세번째 정수를 입력하시오");
//		que3 = sc.nextInt();
//		System.out.print("네번째 정수를 입력하시오");
//		que4 = sc.nextInt();
//				
//		for (int k=1;k<=que1;k++) {
//			for (int i=1;i<=que2;i++) {
//				for (int j=1;j<=que3;j++) {
//					for (int l=1;l<=que4;l++) {
//						System.out.println(k+" * "+i+" * "+j+" * "+l+" = "+k*i*j*l);
//					}
//				}
//				
//			}
//		}
	}
}
