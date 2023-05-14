package g_생성자;

import java.util.Scanner;

public class J0201_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0201_dao dao = new J0201_dao();
//		성명? 지역? 서울S 대전D 부산 B
		
		System.out.print("성명? :");
		String name = sc.next();
		System.out.print("나이? :");
		int age = sc.nextInt();
		System.out.print("지역?(서울-S 대전-D 청주-C 부산-B) :");
		String area = sc.next();
		System.out.print("학력?(중졸-M 고졸-H 대졸-U) :");
		String edu = sc.next();
		
		area = dao.getAreaName(area);
		edu = dao.getEduName(edu);
				
		J0201_dto dto = new J0201_dto(name,area,edu,age);
		
		System.out.println("성명 :"+dto.name);
		System.out.println("지역 :"+dto.area);
		System.out.println("나이 :"+dto.age);
		System.out.println("학력 :"+dto.edu);
		
		
		
	}
}
