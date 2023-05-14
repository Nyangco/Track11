package a_basic;

import java.util.Scanner;

public class J0104_4 {
	public static void main(String[] args) {
		System.out.println("콘솔창에 입력받은 값을 불러오는 기능 - scanner 라는 class 안의 method를 불러와야 한다");
		System.out.println("new 라는 키워드를 사용하면 해당 class를 활성화시킨다.");
		System.out.println("");
		System.out.println("JAVA에서 JRE를 불러올 땐/ class 변수명 = new class();/");
		System.out.println("String class처럼 똑같이 사용하면 된다.");
		System.out.println("new 키워드는 class안에서 method를 뽑아낼 때 사용");
		System.out.println("class나 method 옆에는 무조건 소괄호쌍이 존재.");
		System.out.println("new 기준으로 새로운 class를 만들어서 변수명에 넣는다.");
		System.out.println("소괄호쌍엔 class나 method별로 요구하는 매개변수값-규칙을 넣는다.");
		System.out.println("class명은 중복될 수 있기 때문에, 정확한 패키지의 위치를 입력해야 한다.");
		System.out.println("그 방법으로는, import package.class 방식으로 해당 패키지를 class 안으로 갖고오는 것이다.");
		System.out.println("class에 할당한 변수명 . 을 입력하면 하위 method가 표시된다. ");
		System.out.println("method에 대한 설명중, method 명 다음이 return값의 형식을 말하는 것으로서 이를 대입할 변수의 형식과 맞춰야한다.");
		System.out.println("");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("성명?");
		String a = sc.next(); 
		System.out.println("당신의 성명은 "+a+"입니다.");
		
		System.out.print("국어 점수?");
		int kor = sc.nextInt();
		System.out.println("국어 점수 : "+kor);
		
		System.out.print("영어 점수?");
		int eng = sc.nextInt();
		System.out.println("영어 점수 : "+eng);
		
		int total = kor + eng;
		
	}
}
