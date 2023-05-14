package b_if;

import java.util.Scanner;

public class J0109_3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//total as int, ave as int, kor/eng/mat as int
		
		int total, ave, kor, eng, mat = 0;
		String grade = "";
		
		System.out.print("국어 점수를 입력 :");
		kor = scn.nextInt();
		if(kor>=0 && kor<=100) {
			System.out.print("수학 점수를 입력 :");
			mat = scn.nextInt();
			if(mat>=0 && mat<=100) {
				System.out.print("영어 점수를 입력 :");
				eng = scn.nextInt();
				if(eng>=0 && eng<=100) {
					total = kor+mat+eng;
					ave = total/3;
					if (ave >= 90) grade = "A";
					else if (ave >= 80) grade = "B";
					else if (ave >= 70) grade = "C";
					else if (ave >= 60) grade = "D";
					else grade = "F";
					
					System.out.println("세 과목의 총점 : "+total);
					System.out.println("세 과목의 평균 : "+ave);
					System.out.println("총 학점 : "+grade);
				}else System.out.println("영어점수를 잘못 입력하셨습니다.");
			}else System.out.println("수학 점수를 잘못 입력하셨습니다.");
		}else System.out.println("국어 점수를 잘못 입력하셨습니다.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		Scanner sc = new Scanner(System.in);
		
		String kor,eng,mat="";
		String total = "";
		
		System.out.print("국어점수?");
		kor = sc.next();
		System.out.print("영어점수?");
		eng = sc.next();
		System.out.print("수학점수?");
		mat = sc.next();
		
		total = Integer.toString(
				Integer.parseInt(kor)+
				Integer.parseInt(eng)+
				Integer.parseInt(mat)
				);
		
		if(Integer.parseInt(kor)>=0 && Integer.parseInt(eng)>=0 && Integer.parseInt(mat)>=0) {		
			int ave = Integer.parseInt(total)/3;
			
			String grade = "";
			
			if(ave>=90)			grade="A";
			else if(ave>=80)	grade="B";
			else if(ave>=70)	grade="C";
			else if(ave>=60)	grade="D";
			else				grade="F";		
			
			System.out.println("총점 : "+total);
			System.out.println("평균 : "+ave);
			System.out.println("학점 : "+grade);
		}else System.out.println("잘못 입력하셨습니다.");
		*/
	}
}
