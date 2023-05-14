package d_반복문;

import java.util.Scanner;

public class J0112_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = 0 , total = 0;
		
		for(int k = 1; true ; k++) {
			System.out.print("수 입력");
			input = sc.nextInt();
			if(input == 0) break;
			total += input;
		}
		System.out.println("입력한 수의 합은 "+total+" 입니다.");
	}
}
