package g_생성자;

import java.util.Scanner;

public class J0203_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0203_dao dao = new J0203_dao();
		
		System.out.print("몇명입니까?");
		int count = sc.nextInt();
		
		J0203_dto[] dto = new J0203_dto[count];
		
		for(int k=0; k<dto.length; k++) {
			System.out.print("성명은 무엇입니까? :");
			String name = sc.next();
			System.out.print("성별은 무엇입니까? (남자m, 여자f) :");
			String gender = sc.next();
			System.out.print("나이는 몇살입니까? ");
			int age = sc.nextInt();
			if(age>=0 && age<=120) {
				gender = dao.getGenderName(gender);
				int money = dao.getMoney(gender, age);
				J0203_dto temp = new J0203_dto(name, gender, age, money);
				dto[k] = temp;
			}else {
				System.out.println("나이를 잘못 입력하셨습니다.");
				break;
			}	
		}
		
		dao.printDto(dto);
		
		System.out.print("성명 검색 시스템을 사용하시겠습니까? (예 1 / 아니오 2)");
		String str = sc.next();
		if(str.equals("1")) {
			System.out.print("찾고자 하는 문자열을 입력해주세요");
			String temp = sc.next();
			dao.searchDto(dto,temp);
		}
		
		
	}
}
