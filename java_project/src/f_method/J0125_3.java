package f_method;

import java.util.Scanner;

public class J0125_3 {

	public static void main(String[] args) {
		J0125_3_sub sub = new J0125_3_sub();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("기본급여? ");
		int basic = sc.nextInt();
		System.out.print("성별? 남:1 여:2");
		String gender = sc.next();
		
		int pay = sub.getPay(basic, gender);
		
		System.out.println("최종급여 :"+pay);
		
		
		
	}
}
