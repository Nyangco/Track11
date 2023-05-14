package e_배열;

import java.util.Scanner;

public class J0116_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		
		System.out.print("몇과목?");
		count = sc.nextInt();
		
		int[] score = new int[count];
		
		for(int k=0; k<score.length; k++) {
			System.out.print((k+1)+"번째 과목의 점수를 입력해주세요");
			score[k] = sc.nextInt();
		}
		System.out.println("======================================");
		for(int k=0; k<score.length; k++) {
			System.out.print((k+1)+"번째 과목의 점수 : "+score[k]+"점   \t");
			// \t = 탭을 쳐라
		}
	}
}
