package b_if;

import java.util.Scanner;

public class J0111_2 {

	public static void main(String[] kkk) {
		Scanner sc = new Scanner(System.in);
		
		int month = 0;
		String season = "";
		
		System.out.print("몇 월 입니까?");
		month = sc.nextInt();
		
		if(month >= 1 && month <= 12) {
			if(month >= 3 && month <= 5) {
				season = "봄";
			}else if(month >= 6 && month <= 8) {
				season = "여름";
			}else if(month >= 9 && month <= 11) {
				season = "가을";
			}else season = "겨울";
			System.out.println(month+"월은 "+season+"입니다.");
		}else System.out.println("잘못 입력하셨습니다.");
		
	}
	
	
}
