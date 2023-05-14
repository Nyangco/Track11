package e_배열;

import java.util.Scanner;

public class J0116_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = 0, num2 = 0, num3 = 0;
		String name1 = "";
		
		System.out.print("입력할 인원수는? ");
		num1 = sc.nextInt();
		String[] name = new String[num1];
		
		for(int k=0; k<name.length; k++) {
			System.out.print((k+1)+"번째 인원의 이름을 입력해주세요");
			name[k] = sc.next();
		}
		
		System.out.println("입력받은 인원들의 목록입니다.");
		for(int k=0; k<name.length; k++) {
			System.out.println(name[k]);
		}
		
		System.out.print("문자열 검색 시스템을 이용하시겠습니까? 예:1");
		num2 = sc.nextInt();
						
		if(num2 == 1) {
			System.out.print("검색할 문자열을 입력해주세요");
			name1 = sc.next();
			for(int k=0; k<name.length; k++) {
				if(name[k].indexOf(name1) != -1) {
					num3++; 
					System.out.println("입력하신 문자열은 "+k+"번째에 존재합니다.");
				}
			}
			System.out.println("입력하신 문자열은 "+num3+"번 조회되었습니다.");
		}
	}
}
