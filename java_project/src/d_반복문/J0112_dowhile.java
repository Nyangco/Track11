package d_반복문;

import java.util.Scanner;

public class J0112_dowhile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = 0;
		do {
			System.out.print("선택? 검색[1], 등록[2], 수정[3], 종료[0]");
			k = sc.nextInt();
			
			System.out.println("gubun: "+k);
		}while(k!=0);
		
		System.out.println("종료되었습니다.");
		
//		int a =0;		
//		
//		do a++;	while(a==0);
//		
//		System.out.println(a);
//		
//		a = 0;
//
//		while(a==0) a++;
//		
//		System.out.println(a);
//		
		
		//연습용으로 많이 쓰이는 문법으로서, 무언가를 등록하거나 할때 주로 쓰는 문법이다.
		//do while 문과 while 문의 차이는 1번의 실행을 보장하느냐 아니냐의 차이이다.
		
	}
}
