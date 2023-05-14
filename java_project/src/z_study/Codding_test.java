package z_study;

import java.util.Scanner;

public class Codding_test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int fNum = num;
		int count = 0;
		
		do {
			count++;
			int numT = num/10;
			int numO = num%10;
			int numK = (numT+numO)%10;
			num = numO*10+numK; 
		}while(num!=fNum);
		System.out.println(count);
	}
}
