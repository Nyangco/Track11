package a_basic;


public class J0105_4_형변환 {

	public static void main(String[] args) {
		System.out.println("int / double / String 등의 타입을 서로 변환하는것 - 형변환(Casting)");
		System.out.println("형변환 방법은 (변환하고자 하는 타입)변수 와 같이 쓸 수 있다.");
		int integer = 10;
		double dou = 10.8753;
		
		int num1 = (int)dou;
		double num2 = (double)integer;
		System.out.println(num1);
		System.out.println(num2);
		
		System.out.println("string->int");
		String s = "100";
		int ss = Integer.parseInt(s);
		System.out.println(ss);
		System.out.println("Integer 패키지의 parseInt 라는 method는 소괄호 안의 String(->매개변수)에서 숫자를 추출해서 int의 형태로 받아온다.");
		System.out.println("parseInt의 매개변수는 String type이며, 숫자만 들어간 문자열이여야 한다.");

		System.out.println("int->String");
		int i = 85;
		String ii = Integer.toString(i);
		System.out.println(ii);
		System.out.println("parseInt의 반대급부에 해당하는 method로 toString이 있다. 사용법도 정반대, 매개변수도 정반대.");
		
	}

}
