package g_생성자;

import java.util.Scanner;

public class J0131_1 {
	
	public static void main(String[] args) {
		J0131_1_dao dao = new J0131_1_dao();
		Scanner sc = new Scanner(System.in);
		
		Scanner sc1 = new Scanner("11");
		
		
		String name = "";
		int kor=0, eng=0, mat=0;
//		생성자를 사용하지 않고 객체를 불러올 수 있는가? - 가능 -> 다른 객체에서 생성자를 활용하여서 생성되는가? -> 그렇다.
		
		String name1 = sc1.next();
		System.out.println(name1);
		
		
		System.out.print("성명? :");
		name = sc.next();
		System.out.print("국어 점수? :");
		kor = sc.nextInt();
		System.out.print("영어 점수? :");
		eng = sc.nextInt();
		System.out.print("수학 점수? :");
		mat = sc.nextInt();
		
		J0131_1_dto dto = dao.getDto(name,kor,eng,mat);

		dao.setTotal(dto);
		dao.setAve(dto);
		dao.dtoPrint(dto);
		dao.dtoPrint(dto);
		
	}
}
