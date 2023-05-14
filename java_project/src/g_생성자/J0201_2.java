package g_생성자;

import java.util.Scanner;

public class J0201_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//배열로 몇명? - 몇명에 맞는 dto 만들고, 각각 데이터를 받아서 집어넣고 출력까지
		J0201_dao dao = new J0201_dao();
		
		System.out.print("몇명? :");
		int count = sc.nextInt();
		
		J0201_dto[] arr = new J0201_dto[count];
		
		for(int k=0; k<arr.length; k++) {
			System.out.print("성함? :");
			String name = sc.next();
			System.out.print("나이? :");
			int age = sc.nextInt();
			System.out.print("지역? (서울-S 대전-D 청주-C 부산-B) :");
			String area = sc.next();
			System.out.print("학력? (중졸-M 고졸-H 대졸-U) :");
			String edu = sc.next();
			System.out.println();
			
			area = dao.getAreaName(area);
			edu = dao.getEduName(edu);
			
			arr[k] = dao.getDto(name, area, edu, age);
		}
		
		for(int k=0; k<arr.length; k++) {
			System.out.println((k+1)+"번째 분의 성함 :"+arr[k].name);
			System.out.println((k+1)+"번째 분의 지역:"+arr[k].area);
			System.out.println((k+1)+"번째 분의 나이:"+arr[k].age);
			System.out.println((k+1)+"번째 분의 학력:"+arr[k].edu);
			System.out.println();
		}
		
	
		
	}
}
