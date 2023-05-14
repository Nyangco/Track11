package z_study;

import java.util.Scanner;

public class Bulls_and_Cows {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A=0, B=0, C=0, Str=0, Ball=0, count=0;
		int[] input = new int[3];
		
		System.out.println("숫자야구");
				
		A=(int)(Math.random()*10);
		do {
			B=(int)(Math.random()*10);	
		}while(A==B);
		do {
			C=(int)(Math.random()*10);
		}while(B==C || A==C);
		
		do{
			Str = 0; Ball = 0;
			for(int k=0; k<3; k++) {
				System.out.println((k+1)+" 번째 숫자 입력(0~9)");
				input[k] = sc.nextInt();
				if(input[k]<0 || input[k]>9) {
					System.out.println("다시 입력");
					continue;
				}
			}
			
			
			if(input[0]==A) Str++;
			else if(input[0]==B || input[0]==C) Ball++;
			if(input[1]==B) Str++;
			else if(input[1]==A || input[1]==C) Ball++;
			if(input[2]==C) Str++;
			else if(input[2]==A || input[2]==B) Ball++;
			count++;
			
			if(Str==0 && Ball==0) System.out.println("out");
			else System.out.println("Str : "+Str+" Ball : "+Ball);
		}while (Str!=3);
		
		System.out.println("Result : "+A+"/"+B+"/"+C);
		System.out.println("시도 횟수 : "+count);
		
	}
}
