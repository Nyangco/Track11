package g_생성자;

import java.util.Scanner;

public class J0206_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0206_member_dao dao = new J0206_member_dao();
		
		System.out.print("몇명?");
		int count = sc.nextInt();
		
		J0206_member_dto[] arr = new J0206_member_dto[count];
		
		for(int k=0; k<arr.length; k++) {
			System.out.print((k+1)+"번째 분의 ID? :");
			String id = sc.next();
			System.out.print((k+1)+"번째 분의 성함? :");
			String name = sc.next();
			System.out.print((k+1)+"번째 분의 키? :");
			double height = sc.nextDouble();
			height = dao.confirmDouble(height);
			System.out.print((k+1)+"번째 분의 몸무게? :");
			double weight = sc.nextDouble();
			weight = dao.confirmDouble(weight);
			
			String result = dao.getResult(height, weight);
			
			J0206_member_dto dto = new J0206_member_dto(id, name, height, weight, result);
			arr[k] = dto;			
		}
		
		dao.printArr(arr);
		
		System.out.println("인물 검색 서비스를 개시? (예:1 / 아니오:2) ");
		String conf = sc.next();
		if(conf.equals("1")) {
			System.out.print("찾을 문자열을 입력 :");
			String inputStr = sc.next();
			dao.confirmStr(arr, inputStr);
		}
		
	}
}
