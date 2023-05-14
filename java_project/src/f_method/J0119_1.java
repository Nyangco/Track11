package f_method;

import java.util.Scanner;
// 같은 패키지 안에 있는 method를 호출할 땐 따로 import 하지 않아도 된다!

public class J0119_1 {

	public static void main(String[] args) {
		String kor = "90";
		int korNum = Integer.parseInt(kor);
		/*class는 단순한 설계도 - 주로 쓰는 class는 자동으로 생성됨.
		class는 일반적으로 비슷한 method끼리 묶어놓음
		
		새 method를 생성할 때
		return타입 method명(){}
		*/
		Scanner sc = new Scanner(System.in); 
		J0119_1_sub sub = new J0119_1_sub();
		String name = sub.getName();
		System.out.println(name);
		
		//직접 만든 클래스 이외에도 Object 클래스의 method도 불러올 수 있다.
		//object는 상속받은 method들이다!
		//기본적으로 class를 만들면 부모 클래스로서 Object를 갖는다!
		
		int point = sub.getPoint();
		System.out.println(point);
		
		String kor1 = sub.getKor();
		System.out.println(kor1);
		
		int eng = sub.getEng();
		System.out.println(eng);
		
		int k = 70;
		k = sub.plusNum(k);
		System.out.println(k);
		
		boolean tf = sub.getTrue();
		System.out.println(tf);
		
		
		boolean tFalse = sub.xor(true, false);
		System.out.println(tFalse);
		
		System.out.print("밀가루의 양을 입력해주세요 : ");
		int i = sc.nextInt();
		String size = sub.getNoodle(i);
		System.out.println(size);
		
		
		String pass = sub.getPass(60);
		System.out.println(pass);
		
		
	}
	
}
