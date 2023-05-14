package e_배열;

import java.util.Scanner;

public class J0117_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int inpNum = 0;
		
		System.out.print("과목 수를 입력해주세요");
		inpNum = sc.nextInt();
		
		int[] score = new int[(inpNum+2)];
		
		for(int k=0; k<(inpNum); k++) {
			System.out.print((k+1)+"번째 과목의 성적을 입력해주세요");
			score[k] = sc.nextInt();
			score[inpNum] += score[k];
		}
		score[(inpNum+1)] = score[inpNum]/inpNum; 
		
		for(int k=0; k<score.length; k++) {
			System.out.print(score[k]+"\t");
		}
		
	}
}
