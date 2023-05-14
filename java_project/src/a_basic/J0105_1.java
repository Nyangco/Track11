package a_basic;

import java.util.Scanner;

public class J0105_1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String name="" , area="", age="";
		
		System.out.print("성명은 무엇입니까?");
		name = scn.next();
		
		System.out.print("지역은 어디입니까?");
		area = scn.next();
		
		System.out.print("나이는 몇살입니까?");
		age = scn.next();
		
		System.out.println("성명 : "+name);
		System.out.println("지역 : "+area);
		System.out.println("나이 : "+age);
		
		System.out.println("class명이 같을지라도 포함하고 있는 method는 다를 수 있다 - package 명에 주의!");
		
	}
}
