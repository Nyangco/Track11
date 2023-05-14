package a_basic;

import java.util.Scanner;

public class J0104_study {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("byte 정수를 입력하시오");
	byte num1 = sc.nextByte();
	System.out.println("입력한 정수는"+num1+"입니다.");
	
	System.out.print("short 정수를 입력하시오");
	short num2 = sc.nextShort();
	System.out.println("입력한 정수는"+num2+"입니다.");
	
	System.out.print("int 정수를 입력하시오");
	int num3 = sc.nextInt();
	System.out.println("입력한 정수는"+num3+"입니다.");

	System.out.print("long 정수를 입력하시오");
	long num4 = sc.nextLong();
	System.out.println("입력한 정수는"+num4+"입니다.");

	System.out.print("double 실수를 입력하시오");
	double num5 = sc.nextDouble();
	System.out.println("입력한 실수는"+num5+"입니다.");

	System.out.print("float 실수를 입력하시오");
	float num6 = sc.nextFloat();
	System.out.println("입력한 실수는"+num6+"입니다.");
	
	System.out.print("boolean 참 거짓값을 입력하시오");
	boolean boo = sc.nextBoolean();
	System.out.println("입력한 값은"+boo+"입니다.");

	System.out.print("String 문자열을 입력하시오");
	String str = sc.next();
	System.out.println("입력한 문자열은"+str+"입니다.");
	}
}
