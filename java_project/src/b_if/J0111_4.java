package b_if;

import java.util.Scanner;

public class J0111_4 {

	public static void main(String[] kkk) {
		Scanner sc = new Scanner(System.in);
		
		String name = "", rlt = "불합격";
		int grade, kor, eng, mat, ave = 0;
		
		System.out.print("성명을 입력해주세요 : ");
		name = sc.next();
		System.out.print("학년을 입력해주세요 : ");
		grade = sc.nextInt();
		if(grade >= 1 && grade <= 6) {
			System.out.print("국어 성적을 입력해주세요 : ");
			kor = sc.nextInt();
			System.out.print("영어 성적을 입력해주세요 : ");
			eng = sc.nextInt();
			System.out.print("수학 점수를 입력해주세요 : ");
			mat = sc.nextInt();
			if(kor > 100 || kor < 0 || eng > 100 || eng < 0 || mat > 100 || mat < 0) {
				System.out.println("성적을 잘못 입력하셨습니다.");
			}else {
				ave = (kor+eng+mat)/3;
				
				if(ave >= 80) rlt = "합격";
				else if(ave >= 70 && grade <= 3) rlt = "합격";
				
				System.out.println("성명 : "+name);
				System.out.println("학년 : "+grade+"학년");
				System.out.println("평균 : "+ave+"점");
				System.out.println("결과 : "+rlt);
			}			
		}else System.out.println("학년을 잘못 입력하셨습니다.");
	}
}
