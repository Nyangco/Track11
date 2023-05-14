package b_if;

import java.util.Scanner;

public class J0110_3 {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String job = "";
			int monthSave, year, bounty = 0;
			double finalWon = 0.0;
			
			System.out.print("직업? 학생:1, 주부:2, 회사원:3");
			job = sc.next();
			if(job.equals("1") || job.equals("2") || job.equals("3")) {
					
				System.out.print("월 납입액? : ");
				monthSave = sc.nextInt();
				System.out.print("몇년? : ");
				year = sc.nextInt();
				
				bounty = monthSave * year * 12;
				if(job.equals("1")) finalWon = bounty * 1.2;
				else if(job.equals("2")) finalWon = bounty * 1.1;
				else finalWon = bounty * 1.05;
								
				System.out.println("만기 금액 : "+finalWon+"원");
			} else System.out.println("잘못 입력하셨습니다.");
			
		}
}
