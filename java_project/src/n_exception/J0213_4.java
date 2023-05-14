package n_exception;

import java.util.Scanner;

public class J0213_4 {

	public static void main(String[] args) {
//		throws = 던지다 -> method 뒤에 throws Exception가 붙으면 오류가 발생했을 때 유저에게 에러를 그대로 넘겨주겠다.
//		그렇게 넘어온 오류는 무시가 불가 -> 반드시 try catch 문으로 감싸줘야 한다.
		Scanner sc = new Scanner(System.in);
		J0213_4_sub sub = new J0213_4_sub();
		
//		System.out.print("국어 점수? :");
//		String kor = sc.next();
//		System.out.print("영어 점수? :");
//		String eng = sc.next();
		
		String kor = "80";
		String eng = "90";
		
		int total = 0;
		total = sub.getTotal(kor,eng);
		System.out.println("total : "+total);
		
		int ave = 30;
		try {
			ave = sub.getAve(total, "2kkk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ave : "+ave);
		
		System.out.println("종료");
	}
}
