package g_생성자;

import java.util.Scanner;

public class J0131_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0131_1_dao dao = new J0131_1_dao();
		
		System.out.print("몇 명? : ");
		int count = sc.nextInt();
		J0131_1_dto[] dto = new J0131_1_dto[count];
		
		for(int k=0; k<dto.length; k++) {
			System.out.print((k+1)+"번째 사람의 성명? :");
			String name = sc.next();
			System.out.print((k+1)+"번째 사람의 국어 점수? :");
			int kor = sc.nextInt();
			System.out.print((k+1)+"번째 사람의 영어 점수? :");
			int eng = sc.nextInt();
			System.out.print((k+1)+"번째 사람의 수학 점수? :");
			int mat = sc.nextInt();
			J0131_1_dto temp = new J0131_1_dto(name, kor, eng, mat);
			dao.setTotal(temp);
			dao.setAve(temp);
			dto[k]=temp;
		}

		dao.dtoArrPrint(dto);
		
	}
}
