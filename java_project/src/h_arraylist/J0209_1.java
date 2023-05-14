package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0209_1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0209_1_dao dao = new J0209_1_dao();
		ArrayList<J0209_1_dto> arr = new ArrayList<>();
		boolean checksum = true;
		
		while(true) {
			System.out.print("성함을 입력해주세요");
			String name = sc.next();
			System.out.print("나이를 입력해주세요");
			int age = sc.nextInt();		
			if(!dao.checkAge(age)) {
				System.out.println("나이 입력 오류");
				checksum=false;
				break;
			}	
			System.out.print("성별을 입력해주세요");
			String gender = sc.next();
			
			int pay = dao.getPay(gender,age);
			arr.add(new J0209_1_dto(name,gender,pay,age));
			
			System.out.println("종료하시겠습니까? (y/n)");
			String input = sc.next();
			if(input.equals("y")) break;
		}
		
		if(checksum==true) dao.printArrList(arr);
		
	}

}
