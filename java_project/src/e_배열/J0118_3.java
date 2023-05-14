package e_배열;

import java.util.Scanner;

public class J0118_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇명?");
		int j = sc.nextInt();
		
		String[][] str = new String[j][3];		
		
		for(int k=0; k<str.length; k++) {
			for(int i=0; i<str[k].length; i++) {
				if(i==0) System.out.print("성명?");
				else if(i==1) System.out.print("지역?");
				else if(i==2) System.out.print("나이?");
				str[k][i] = sc.next();
			}
		}
				
		for(int k=0; k<str.length; k++) {
			for(int i=0; i<str[k].length; i++) {
				System.out.print(str[k][i]+"\t");
			}
			System.out.println();
		}
		
	}
}
