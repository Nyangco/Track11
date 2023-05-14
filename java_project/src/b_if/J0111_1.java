package b_if;

import java.util.Scanner;

public class J0111_1 {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			String month, season = "";
			int monthInt = 0;
			
			System.out.print("오늘은 몇 월입니까?");
			month = sc.next();
			
			monthInt = Integer.parseInt(month);
			
			if(monthInt <= 12 && monthInt >= 1) {			
				if(monthInt == 3 || monthInt == 4 || monthInt == 5) {
					season = "봄";
				}else if(monthInt == 6 || monthInt == 7 || monthInt == 8) {
					season = "여름";
				}else if(monthInt == 9 || monthInt == 10 || monthInt == 11) {
					season = "가을";
				}else {
					season = "겨울";
				} System.out.println(month+"월은 "+season+" 입니다.");
			}else System.out.println("잘못 입력하셨습니다.");
			
			
		}
}
