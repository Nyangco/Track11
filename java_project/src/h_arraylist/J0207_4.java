package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0207_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0207_4_dao dao = new J0207_4_dao();
		
		ArrayList<J0207_4_dto> arr = new ArrayList<>();
		
		System.out.print("몇 명?");
		int count = sc.nextInt();
		
		for(int k=0; k<count; k++) {
			System.out.print("ID? ");
			String id = sc.next();
			System.out.print("성명? ");
			String name = sc.next();
			System.out.print("나이? ");
			int age =sc.nextInt();
			System.out.print("부서 [총무:10, 재무:20, 영업:30] ? ");
			String depart = sc.next();
			System.out.print("직위 [사원:s, 대리:d, 과장:g] ? ");
			String rank = sc.next();
			
			depart = dao.getDepart(depart);
			rank = dao.getRank(rank);
			
			arr.add(new J0207_4_dto(id,name,depart,rank,age));
		}
		
		dao.printArrList(arr);
		
		System.out.print("사원 검색 시스템 실행? (y/n)");
		String input = sc.next();
		if(input.equals("y")) {
			System.out.print("찾고자 하는 문자열 입력");
			String find = sc.next();
			dao.findName(arr,find);
		}
	}
}
