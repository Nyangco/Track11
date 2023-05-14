package b_if;

import java.util.Scanner;

public class J0109_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String gender,gend = "";
		int hp=0;
		String result = "비정상";
		
		System.out.print("성별 입력(남성 : 1, 여성 :2) :");
		gender = sc.next();
		if(gender.equals("1")||gender.equals("2")) {
			if(gender.equals("1")) gend = "남성";
			if(gender.equals("2")) gend = "여성";
			
			System.out.print("체력지수 입력 :");
			hp = sc.nextInt();
			if(hp>=0) {
				if(hp>=75||(gender.equals(2)&&hp>=65)) {
					result="정상";
				}
				System.out.println("결과 : "+gend+" "+result);
			}else System.out.println("체력지수를 잘못 입력하셨습니다.");
			
		}else System.out.println("성별을 잘못 입력하셨습니다.");
		
	}
}
