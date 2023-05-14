package b_if;

import java.util.Scanner;

public class J0111_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int error = 0;
		String season, seasonStr = ""; 
		
		System.out.print("계절? 봄:1, 여름:2, 가을:3, 겨울:4");
		season = sc.next();
		
		if(season.equals("1")) {
			season = "봄";
			seasonStr = "3월~5월";
		}
		else if(season.equals("2")) {
			season = "여름";
			seasonStr = "6월~8월";
		}
		else if(season.equals("3")) {
			season = "가을";
			seasonStr = "9월~11월";
		}
		else if(season.equals("4")) {
			season = "겨울";
			seasonStr = "12월~2월";
		}
		else {
			error = 1;
			System.out.println("입력 오류");
		}
		
		if(error == 0) System.out.println(season+"은 "+seasonStr+"까지 입니다.");
	}
}
