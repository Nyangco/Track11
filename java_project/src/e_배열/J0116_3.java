package e_배열;

import java.util.Scanner;

public class J0116_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = 0, num2 = 0;
		String name1 = "";
		
		System.out.print("입력하실 인원수는 몇명입니까?");
		num1 = sc.nextInt();
		
		String[] name = new String[num1];
		
		for(int k = 0; k<name.length; k++) {
			System.out.print((k+1)+"번째 인원의 성함을 입력해주세요");
			name[k] = sc.next();
		}
		
		for(int k = 0; k<name.length; k++) {
			System.out.println((k+1)+"번째 인원의 성함은"+name[k]+"입니다.");
		}
		
		System.out.print("검색하실 성함을 입력해주세요");
		name1 = sc.next();
		
		for(int k = 0; k<name.length; k++) {
			if(name[k].indexOf(name1)!= -1 ) {
				num2++;
				System.out.println((k+1)+"번째 "+name[k]+"이 존재합니다.");
			}
		}
		System.out.println(num2+"명의 검색결과가 나왔습니다.");
		
		
	}
}
