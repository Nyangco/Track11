package e_배열;

import java.util.Scanner;

public class J0117_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//앞에꺼 배열 타입을 String으로
		//
		int num = 0, total = 0, ave = 0;
		
		System.out.print("과목 갯수");
		num = sc.nextInt();
		
		String[] score = new String[num+2];
		for(int k=0; k<num; k++) {
			System.out.print("각 과목의 점수를 입력");
			score[k] = sc.next();
			total += Integer.parseInt(score[k]);
		}
		ave = total/num;
		score[num] = Integer.toString(total);
		score[num+1] = Integer.toString(ave);
		
		for(int k=0; k<score.length; k++) {
			System.out.print(score[k]+"\t");
		}
		
		
	}
}
