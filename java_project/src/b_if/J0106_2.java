package b_if;

import java.util.Scanner;

public class J0106_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("남?여?");
		String gender = sc.next();
		
		if(gender.equals("남")) {
//			System.out.println("남자");
			
			System.out.print("군필:1, 미필:2");
			String mil = sc.next();
			
			if(mil.equals("1")) {
				System.out.println("군필 남자");
			}else if(mil.equals("2")){
				System.out.println("미필 남자");
			}else System.out.println("입력오류");
			
		}else if(gender.equals("여")) {
			System.out.println("여자");
		}else System.out.println("입력 오류");

		
		System.out.println("종료");
	}

}
