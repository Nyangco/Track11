package b_if;

import java.util.Scanner;

public class J0110_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = 500000, error=0;
		String job = "";
		
		System.out.print("직업은 무엇입니까? - 학생:1, 주부:2, 회사원:3 ");
		job = sc.next();
		
		if(job.equals("1")) {
			money+=100000;
			job = "학생";
		}
		else if(job.equals("2")) {
			money+=300000;
			job = "주부";
		}
		else if(job.equals("3")) {
			money+=400000;
			job = "회사원";
		}else {
			System.out.println("잘못 입력하셨습니다. 다시 확인해주세요");
			error = 1;
		}
		
		if(error==0) System.out.println(job+" : "+money);
		
		
		System.out.println();
//		기본 생활비 500,000 
//		학생:+100,000
//		주부:+100,000
//		회사원:+400,000
	}
}
