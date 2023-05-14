package g_생성자;

import java.util.Scanner;

public class J0201_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0201_dao dao = new J0201_dao();
		J0201_dto[] dto = new J0201_dto[2];
		
		for(int k=0; k<dto.length; k++) {
			System.out.print("이름? :");
			String name = sc.next();
			System.out.print("나이? :");
			int age = sc.nextInt();
			System.out.print("지역? :");
			String area = sc.next();
			System.out.print("학력? :");
			String edu = sc.next();
			System.out.println();
			
			J0201_dto temp = new J0201_dto(name,area,edu,age);
			dto[k]=temp;	
		}
		
		dao.dtoPrint(dto);
		
		
		
		
	}
}
