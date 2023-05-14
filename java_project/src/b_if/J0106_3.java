package b_if;

import java.util.Scanner;

public class J0106_3 {

	public static void main(String[] args) {
		int grade, score = 0;
		String pass ="";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학년을 입력해주세요(1학년 : 1)");
		grade = sc.nextInt();
		if(grade<=6 && grade>=1) {
			System.out.print("성적을 입력해주세요");
			score = sc.nextInt();
			if(score>=1) {		
				if(score>=80||(score>=70 && grade<=3)) {
					pass = "합격";
					System.out.println(grade+"학년 "+score+"점 "+pass);		
				} else {
					pass = "불합격";
					System.out.println(grade+"학년 "+score+"점 "+pass);		
				}
			} else System.out.println("성적 입력오류");
		} else System.out.println("학년 입력오류");
	}

}
