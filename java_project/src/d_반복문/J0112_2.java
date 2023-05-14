package d_반복문;

import java.util.Scanner;

public class J0112_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = 0, num2 = 0, num3 = 0, num4 = 0;
		String odd = "";
		
		System.out.print("몇부터?");
		num1 = sc.nextInt();
		System.out.print("몇까지?");
		num2 = sc.nextInt();
		System.out.print("짝수? 홀수?");
		odd = sc.next();
		
		if(num1 > num2) {
			num4 = num1;
			num1 = num2;
			num2 = num4;
		}
		
		if(odd.equals("홀수") || odd.equals("짝수")) {
			
			if(odd.equals("홀수")) num4 = 1;
			else num4 = 0;
			
			for(int k = num1 ; k <= num2 ; k++) {
				if(k%2 == num4) {
					System.out.println("K : "+k);
					num3++;
				}
			}
			
			System.out.println("총 "+odd+"의 갯수는 "+num3+"입니다.");
		}else System.out.println("짝수 홀수를 잘못 입력하셨습니다.");
	}
}
