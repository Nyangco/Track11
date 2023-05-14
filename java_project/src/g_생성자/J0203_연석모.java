package g_생성자;

import java.util.Scanner;

public class J0203_연석모 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0203_연석모_dao dao = new J0203_연석모_dao();
		
		System.out.print("몇명 인가요? :");
		int count = sc.nextInt();
		
		J0203_연석모_dto[] arr = new J0203_연석모_dto[count];
		for(int k=0; k<arr.length; k++) {
			System.out.print("성함을 입력해주세요 :");
			String name = sc.next();
			System.out.print("국어 점수를 입력해주세요 :");
			int kor = sc.nextInt();
			if(dao.checkScore(kor))break;
			System.out.print("영어 점수를 입력해주세요 :");
			int eng = sc.nextInt();
			if(dao.checkScore(eng))break;
			System.out.print("수학 점수를 입력해주세요 :");
			int mat = sc.nextInt();
			if(dao.checkScore(mat))break;
			
			double ave =dao.getAve(kor,eng,mat);
			String pass = dao.getPass(ave);
			if(ave>=80) pass="합격";
			else pass="불합격";
			
			J0203_연석모_dto dto = new J0203_연석모_dto(name, pass, kor, eng, mat, ave);
			arr[k] = dto;
		}
		
		dao.printArr(arr);
		
		System.out.print("성명을 검색하시겠습니까? (y/n)");
		String temp = sc.next();
		if(temp.equals("y")) {
			System.out.print("찾고자 하는 문자열을 입력해주세요");
			String str = sc.next();
			dao.searchDto(arr,str);
			
		}
	}
}
