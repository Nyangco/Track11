package g_생성자;

import java.util.Scanner;

public class J0206_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0206_2_dao dao = new J0206_2_dao();
		
		System.out.print("몇 명? :");
		int count = sc.nextInt();
		
		J0206_2_dto[] arr = new J0206_2_dto[count];
		for(int k=0; k<arr.length; k++) {
			System.out.print("id? :");
			String id = sc.next();
			System.out.print("성명? :");
			String name = sc.next();
			System.out.print("국어? :");
			int kor = sc.nextInt();
			if(kor>100 || kor<0) {
				System.out.println("국어 점수 잘못 입력");
				break;
			}
			System.out.print("영어? :");
			int eng = sc.nextInt();
			if(eng>100 || eng<0) {
				System.out.println("영어 점수 잘못 입력");
				break;
			}
			System.out.print("수학? :");
			int mat = sc.nextInt();
			if(mat>100 || mat<0) {
				System.out.println("수학 점수 잘못 입력");
				break;
			}
			
			double ave = dao.getAve(kor,eng,mat);
			String result = dao.getResult(kor,eng,mat);
			
			J0206_2_dto dto = new J0206_2_dto(id,name,result,kor,eng,mat,ave);
			arr[k] = dto;			
		}
		
		dao.printArr(arr);
	}
}
