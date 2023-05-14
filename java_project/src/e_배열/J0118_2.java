package e_배열;

import java.util.Scanner;

public class J0118_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] score = new int[2][3];
		
		for(int k=0; k<score.length; k++) {
			for(int i=0; i<score[k].length; i++) {
				System.out.print((k+1)+"행의 "+(i+1)+"열에 들어갈 숫자를 입력해주세요.");
				score[k][i]=sc.nextInt();
			}
		}
		
		for(int k=0; k<score.length; k++) {
			for(int i=0; i<score[k].length; i++) {
				System.out.print(score[k][i]+"\t");
			}
			System.out.println("");
		}
		
		
		
		
	}
}
