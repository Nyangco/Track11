package b_if;

import java.util.Scanner;

public class J0106_4 {
	public static void main(String[] args) {
		//eqaul 용법과 if의 상세한 비교조건
		
		Scanner sc = new Scanner(System.in);
		String id,inputid="";
		int pw, inputpw = 0;
		
		id = "ysm951204";
		pw = 9184;
		
		System.out.print("ID를 입력하세요");
		inputid = sc.next();
		if(inputid.equals(id)) {
			System.out.print("비밀번호를 입력하세요");
			inputpw = sc.nextInt();
			if(inputpw==pw) {
				System.out.println("이메일 주소는 ysm951204a@naver.com 입니다.");
			}else System.out.println("비밀번호를 잘못 입력하셨습니다.");
		}else System.out.println("ID를 잘못 입력하셨습니다.");
	}
}
