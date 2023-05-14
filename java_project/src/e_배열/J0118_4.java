package e_배열;

import java.util.Scanner;

public class J0118_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇명?");
		int num1 = sc.nextInt()+1;
		System.out.print("몇과목?");
		int num2 = sc.nextInt()+1;
		
		String[][] table = new String[num1][num2];
		
		
		table[0][0] = "성명";		
		for(int i=1; i<table[0].length; i++) {
			table[0][i] = i+"번째 과목";
		}
		
		for(int k=1; k<table.length; k++) {
			for(int i=0; i<table[k].length; i++) {
				if(i==0) System.out.print("성명?");
				else System.out.print(i+"번째 과목의 점수?");
				table[k][i] = sc.next();
			}
		}
		
		for(int k=0; k<table.length; k++) {
			for(int i=0; i<table[k].length; i++) {
				System.out.print(table[k][i]+"\t");
			}
			System.out.println("");
		}

		
		
		
	}
}
