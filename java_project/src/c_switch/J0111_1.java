package c_switch;

import java.util.Scanner;

public class J0111_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String month, season = "";
		int mon = 0;
		
		System.out.print("몇 월 입니까?");
		month = sc.next();
		
		switch(month) {
			case "1" : case "2" : case "12" :
				season = "겨울";
				break;
			case "3" : case "4" : case "5" : 
				season = "봄";
				break;
			case "6" : case "7" : case "8" : 
				season = "여름";
				break;
			case "9" : case "10" : case "11" :
				season = "겨울";
				break;
			default : System.out.println("입력오류");
				
			
		}
		
		mon = Integer.parseInt(month);
		
		switch(mon) {
		case 1: case 2: case 12:
			season = "겨울";
			break;
		case 3: case 4: case 5:
			season = "봄";
			break;
		case 6: case 7: case 8:
			season = "여름";
			break;
		case 9: case 10: case 11:
			season = "가을";
			break;
		default :
			break;
		}
		
		System.out.println(season);
		
		
		/*
		switch 문의 양식
		switch(변수 지정) / case(변수값에 대응) 비교할 대상 : / 실행문~ break; / defalut : / 실행문;
		break가 없으면 다음 case도 실행하기 때문에 필수로 들어가야 한다.
		if문의 else와 같은 용법으로 사용할 수 있는 default가 있다 - 사용법 역시 동일하다.
		switch 문의 case는 여러개를 붙여서 하나의 실행문단을 실행하게 할 수 있다.
		 */
		System.out.println(season);
		
		
		String season2 = "";
		if(month.equals("1")) season2="겨울";
		else if(month.equals("2")) season2="봄";
		else if(month.equals("3")) season2="봄";
		else System.out.println("입력오류");
		
		System.out.println(season);
	}
}
