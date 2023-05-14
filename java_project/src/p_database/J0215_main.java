package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0215_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0215_dao dao = new J0215_dao();
		ArrayList<J0214_dto> dtos = new ArrayList<>();
		
//		NullPointerException : null인 객체를 참조로 어떤 데이터를 뽑고자 할때 생성되는 exception.
		
		dtos = dao.getMemberList("");
		dao.printArrList(dtos);
		
		System.out.print("검색 서비스를 실행하시겠습니까? y/n");
		if(sc.next().equals("y")) {
			
			System.out.print("무엇을 검색하시겠습니까?");
			String index = sc.next();
			System.out.print("찾으실 항목을 입력해주십시오");
			String value = sc.next();
			
			String query = "and "+index+" like '%"+value+"%'";
			dtos=dao.getMemberList(query);
			dao.printArrList(dtos);
			
		}
		
		
		
	}
}
