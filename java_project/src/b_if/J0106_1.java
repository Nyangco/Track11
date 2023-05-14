package b_if;

import java.util.Scanner;

public class J0106_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		String gender = "남";
		if(gender.contentEquals("남")) {
			System.out.println("같다");
		}
		
		System.out.print("성별을 입력해주세요");
		String gen = scn.next();
		
		System.out.print("나이를 입력하세요");
		int age = scn.nextInt();
		
		
		if((gen.equals("남")||gen.equals("남자")||gen.equals("남성"))&&age>=20) {
			System.out.println("100만원");
		}
		
		
		if(gen.equals("남")||age>=20) {
			System.out.println("50만원");
		}
		
		
		
			System.out.println("String 역시 하나의 클래스다 - . 찍으면 여러 method가 튀어나온다.");
		System.out.println("다만 new String()을 생략할 수 있는 class이다.");
		System.out.println("하여 == 대신 .equals 라는 method를 사용하고, 이는 매개변수를 객체로 받아서 true와 false를 반환하는 것이다.");
		
	}

}
