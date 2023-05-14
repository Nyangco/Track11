package a_basic;

import z_study.Temp;

public class J0104_1 extends z_study.Temp{

	public static void main (String[] args) {
		// TODO Auto-generated method stub
			byte num1 = 127;
			short num2 = -32768;
			int num3 = -2147483648;
			long num4 = -9223372036854775808l;
			
			float num5 = 10.0f;
			double num6 = 10.97;
			
			boolean tf = true;
			
			char cch = 'k';
			
			String str = "String";
			System.out.println("성명"+str);
			
		System.out.println();
			
		System.out.println("java 시작");
		System.out.println("print는  method 라고 한다 - function과 같은 의미 -> jre 안에 들어있음");
		System.out.println("모든 method는 다른 method 안에 위치해야 한다->main method 안이나 다른 함수의 안에");
		System.out.println("class의 영역 안에는 변수만 선언할 수 있다.");
		System.out.println("정수를 선언하기 위해선 int, 문자열을 선언하기 위해선 String을 사용한다.(대문자 주의)");
		System.out.println("int는 -21억 정도부터 21억 정도까지 - 4바이트 짜리 변수 - -2의 31승부터 +2의 31승-1 까지");
		System.out.println("byte - short - int - long");
		System.out.println("1바이트 - 2바이트 - 4바이트 - 8바이트");
		System.out.println("long은 뒤에 l을 붙여준다");
		System.out.println("float과 double은 실수를 표현하기 위한 두가지 타입이다.");
		System.out.println("float는 값 뒤에 f를 붙여준다.");
		System.out.println("float는 4바이트, double은 8바이트이며 float은 소숫점 7자리, double은 15~16자리까지 표현이 가능하다");
		System.out.println("참 거짓을 대입하기 위한 변수선언자는 boolean이다.");
		System.out.println("char는 단 한글자를 대입하기 위한 변수타입으로서, 작은 따옴표로 묶어주는 것이 특징");
		System.out.println("통상적으로 사용하기 위해선 String을 사용");
		System.out.println("String은 char에 method를 추가한 것으로서, char의 배열 같은거라고 생각하면 된다.");
		System.out.println("그래서 char는 작은따옴표로 표현(큰따옴표 안으로 들어가니까)");
		System.out.println("j.querry의 charAt은 여기서 따온듯");
		System.out.println("");
		System.out.println("sysout + ctrl + space 누르면 println으로 변환");
		
		
		z_study.Temp temp = new z_study.Temp();
		
	
	}

}
