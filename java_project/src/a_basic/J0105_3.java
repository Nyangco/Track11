package a_basic;

import java.util.Scanner;

public class J0105_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		String name = "";
		int total = 0;
		double avg = 0, subject=0;
		
		System.out.print("성명을 입력하세요");
		name = scn.next();
		
		System.out.print("총점을 입력하세요");
		total = scn.nextInt();
		
		System.out.print("과목 수를 입력하세요");
		subject = scn.nextDouble();
		
		avg = total/subject;
		
		System.out.println("=============");
		System.out.println("성명 : "+name);
		System.out.println("총점 : "+total+"점");
		System.out.println("평균 : "+avg+"점");
		System.out.println("=============");
	}

}
