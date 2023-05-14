package b_if;

import java.util.Scanner;

public class J0109_4 {
	public static void main(String[] args) {
		//2개의 수를 입력받고 사칙연산 여부를 입력받아서 결과를 출력하는 계산기
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, rlt = 0;
		String tool = "";
		
		System.out.print("첫번째 수를 입력 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 수를 입력 : ");
		num2 = sc.nextInt();
		System.out.print("연산도구를 입력 : ");
		tool = sc.next();
		
		if(tool.equals("+")||tool.equals("-")||tool.equals("*")||tool.equals("/")) {
			if(tool.equals("+")) rlt=num1+num2;
			else if(tool.equals("-")) rlt=num1-num2;
			else if(tool.equals("*")) rlt=num1*num2;
			else rlt=num1/num2;
			
			System.out.println(num1+tool+num2+" = "+rlt);
		}else System.out.println("연산자를 잘못 입력하셨습니다.");
		
	}
}


//24문제, NCS 책에서 나옴, 요점정리!
