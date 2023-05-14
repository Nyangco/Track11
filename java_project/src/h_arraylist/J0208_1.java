package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0208_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0208_1_dao dao = new J0208_1_dao();
		ArrayList<J0208_1_dto> arr = new ArrayList<>();
		//+과목별 총점 까지 출력
		while(true) {
			System.out.print("학년을 입력(숫자로)");
			String grade = sc.next();
			System.out.print("반을 입력(숫자로)");
			String ban = sc.next();
			System.out.print("학생 번호를 입력");
			String number = sc.next();
			System.out.print("성명을 입력");
			String name = sc.next();
			System.out.print("국어 점수를 입력");
			int kor = sc.nextInt();
			System.out.print("영어 점수를 입력");
			int eng = sc.nextInt();
			System.out.print("수학 점수를 입력");
			int mat = sc.nextInt();
			int total=kor+eng+mat;
			
			arr.add(new J0208_1_dto(grade, ban, number, name, kor, eng, mat,total));
			System.out.print("계속 입력하시겠습니까? (y/n)");
			String confirm = sc.next();
			if(confirm.equals("y") || confirm.equals("Y") || confirm.equals("ㅛ"));
			else break;
		}
		
		dao.getRank(arr);		
		dao.printArrList(arr);
		dao.getRank(arr);
		
		
	}
}
