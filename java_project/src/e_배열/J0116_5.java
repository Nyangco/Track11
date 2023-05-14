package e_배열;

import java.util.Scanner;

public class J0116_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int subject = 0, total = 0;
		
		System.out.print("입력할 과목의 수를 입력해주세요 : ");
		subject = sc.nextInt();
		
		int[] score = new int[subject];
		
		for(int k=0; k<score.length; k++) {
			System.out.print((k+1)+"번째 과목의 점수를 입력해주세요");
			score[k] = sc.nextInt();
		}
		
		for(int k=0; k<score.length; k++) {
			System.out.print((k+1)+"번째 과목 :"+score[k]+"\t");
			total += score[k];
		}
		System.out.println("총점 : "+total);
	}
}
