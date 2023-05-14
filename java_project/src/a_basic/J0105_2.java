package a_basic;

import java.util.Scanner;

public class J0105_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name = "";
		int kor , eng , mat = 0;
		double avg = 0.0;
		
		System.out.print("성명을 입력하세요");
		name = sc.next();
		System.out.print("국어 점수를 입력하세요");
		kor = sc.nextInt();
		System.out.print("영어 점수를 입력하세요");
		eng = sc.nextInt();
		System.out.print("수학 점수를 입력하세요");
		mat = sc.nextInt();
		
		avg = (kor+eng+mat)/3.0;
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("성명 : "+name);
		System.out.println("국어 : "+kor+"점");
		System.out.println("영어 : "+eng+"점");
		System.out.println("수학 : "+mat+"점");
		System.out.println("총점 : "+(kor+eng+mat)+"점");
		System.out.println("평균 : "+avg+"점");
	}
	

}
