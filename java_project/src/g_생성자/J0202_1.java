package g_생성자;

import java.util.Scanner;

public class J0202_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0202_dao dao = new J0202_dao();
		
		System.out.print("회사 인원은 몇명인가요? :");
		int count = sc.nextInt();
		
		J0202_dto[] company = new J0202_dto[count];

		for(int k=0; k<company.length; k++) {
			System.out.print("사번? :");
			String idNum = sc.next();
			System.out.print("성명? :");
			String name = sc.next();
			System.out.print("부서[총무:c, 재무:j, 영업:y]? :");
			String depart = sc.next();
			System.out.print("직위[사원:10, 대리:20, 과장:30]? :");
			String rank = sc.next();
			System.out.println();
			
			depart = dao.getDepartName(depart);
//			해당 클래스의 method를 바로 찾아가는 단축키 - 해당 method 위에 커서 올려놓고 F3
			rank = dao.getRankName(rank);
			int pay = dao.getPay(depart, rank);
			
			J0202_dto salaryMan = new J0202_dto(idNum,name,depart,rank,pay);
			company[k]=salaryMan;
		}
		
		dao.setPrint(company);
		
		System.out.println("==========================================");
		System.out.print("성명 검색? :");
		String search = sc.next();
		dao.searchData(company, search);
	}
}
