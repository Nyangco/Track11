package b_if;

import java.util.Scanner;

public class J0110_4 {
	
	public static void main(String[] kkk) {
		Scanner sc = new Scanner(System.in);
		
		int score, grade = 0;
		String pass = "불합격";
		
		System.out.print("학년?");
		grade = sc.nextInt();
		
		if(grade<=6 && grade>=1) {
			System.out.print("성적?");
			score = sc.nextInt();
			
			if(score>=0 && score<=100) {
				
				if(score>=80) pass = "합격";
				else if(score>=70 && grade<=3) pass = "합격";
				
				System.out.println(grade+"학년 "+pass);				
			}else System.out.println("성적 입력오류");
		}else System.out.println("학년 입력오류");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		String grade = "", pass = "불합격";
		int score = 0;
		
		System.out.print("학년?");
		grade = sc.next();
		
		if(Integer.parseInt(grade)<=6 && Integer.parseInt(grade)>=1) {				
			System.out.print("평균?");
			score = sc.nextInt();
			
			if(score>=0 && score<=100) {
				if(score>=80) pass = "합격";
				else if(score>=70 && Integer.parseInt(grade)<=4) pass="합격";
				else if(score>=60 && Integer.parseInt(grade)<=2) pass="합격";
				System.out.println(grade+"학년 "+pass);
				
			}else System.out.println("성적 입력오류");
		}else System.out.println("학년 입력오류");		
		*/
	}
}
