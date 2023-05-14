package b_if;

import java.util.Scanner;

public class J0109_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ave = 0;
		String score = "";
		
		System.out.print("평균을 입력하세요");
		ave = sc.nextInt();
		
		if(ave>=0&&ave<=100) {
			if(ave>=90) {
				score = "A";
			}else if(ave>=80) {
				score = "B";
			}else if(ave>=70) {
				score = "C";
			}else if(ave>=60) {
				score = "D";
			}else score = "F";
			System.out.println("결과 : "+score);
		}else System.out.println("점수를 잘못 입력하셨습니다.");
	}
}
