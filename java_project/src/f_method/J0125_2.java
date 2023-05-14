package f_method;

import java.util.Scanner;

public class J0125_2 {
	public static void main(String[] asssasdasdasd) {
		Scanner sc = new Scanner(System.in);
		J0125_2_sub sub = new J0125_2_sub();
		
		//국영수 점수 물어보고 return int로
		
		System.out.print("국어? :");
		int kor = sc.nextInt();
		System.out.print("수학? :");
		int mat = sc.nextInt();
		System.out.print("영어? :");
		int eng = sc.nextInt();
		
		int total = sub.getTotal(kor, eng, mat);
		double ave = sub.getAve(total, 3);
		String result = sub.getResult(ave);
		
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+ave);
		System.out.println("결과 : "+result);
		
	}

}
