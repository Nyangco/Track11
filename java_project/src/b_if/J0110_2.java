package b_if;

import java.util.Scanner;

public class J0110_2 {
	public static void main(String[] kkk) {
		Scanner sc = new Scanner(System.in);
		
		int basic = 0, error=0;
		String job = "";
		
		System.out.print("기본 생활비 설정?");
		basic = sc.nextInt();
		
		System.out.print("직업? 학생:1, 주부:2, 회사원:3");
		job = sc.next();
		
		if(job.equals("1")) {
			basic+=100000;
			job="학생";
		} else if(job.equals("2")) {
			basic+=300000;
			job="주부";
		} else if(job.equals("3")) {
			basic+=400000;
			job="회사원";
		} else {
			System.out.println("잘못 입력하셨습니다.");
			error = 1;
		}
		
		if(error==0) System.out.println(job+" : "+basic);
		
	}
}
