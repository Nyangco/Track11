package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0222_연석모_employee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0222_연석모_employee_dao dao = new J0222_연석모_employee_dao();
		int gubun = 0, num = 0;
		ArrayList<J0222_연석모_employee_dto> arr = new ArrayList<>();
		
		
		
		do {
			arr = null; num = 0; 
			System.out.print("조회[1], 등록[2], 수정[3], 삭제[4], 종료[0]");
			gubun = sc.nextInt();
			
			if(gubun==1) {
				System.out.print("조건부 조회? (y/n)");
				String input = sc.next();
				if(input.equals("y") || input.equals("Y") || input.equals("ㅛ")) {
					System.out.print("어느 항목을? (사번:1 / 성명:2 / 부서:3 / 직위:4 / 나이:5)");
					String column = dao.getColumn(sc.nextInt());
					if(column.equals("error")) System.out.println("항목 입력오류");
					else {
						System.out.print("찾고자 하는 문자열?");
						String value = sc.next();
						arr = dao.selectDB(column, value);
						dao.printArrList(arr);	
					}					
				}else if(input.equals("n") || input.equals("N") || input.equals("ㅜ")) {
					arr = dao.selectDB("id","");
					dao.printArrList(arr);	
				}else System.out.println("다시 입력");
			}else if(gubun==2) {
				J0222_연석모_employee_dto dto = dao.getDto();
				if(dto != null) {
					num = dao.insertDB(dto);
					if(num==1) System.out.println("Done!");
					else System.out.println("failed..");
				}
			}else if(gubun==3) {
				System.out.print("어느 id?");
				String id = sc.next();
				if(id.length()!=3) System.out.println("id는 3자리");
				else if(dao.selectDB("id",id).size()==0) System.out.println("id가 존재하지 않음");
				else {
					dao.printArrList(dao.selectDB("id",id));
					System.out.print("어떻게 수정? (전체:1, 일부:2, 취소:3)");
					int input = sc.nextInt();
					if(input==1) {
						J0222_연석모_employee_dto dto = dao.getDto(id);
						if(dto != null) {
							num = dao.updateDB(id,dto);
							if(num==1) System.out.println("Done!");
							else System.out.println("failed..");
						}
					}else if(input==2) {
						System.out.print("어느 항목을? (성명:2 / 부서:3 / 직위:4 / 나이:5)");
						String column = dao.getColumn(sc.nextInt());
						if(column.equals("error")) System.out.println("항목 입력오류");
						else {
							System.out.print("어떻게?");
							String value = sc.next();
							num = dao.updateDB(id, column, value);
							if(num==1) System.out.println("Done!");
							else System.out.println("failed..");
						}
					}else if(input==3) {
						System.out.println("수정이 취소됨");
					}else {
						System.out.println("다시 입력");
					}
				}
			}else if(gubun==4) {
				System.out.print("어느 id?");
				String id = sc.next();
				if(id.length()!=3) System.out.println("id는 3자리");
				else {
					dao.printArrList(dao.selectDB("id",id));
					System.out.print("정말 삭제? (y/n)");
					String input = sc.next();
					if(input.equals("Y") || input.equals("y") || input.equals("ㅛ")) {
						num = dao.deleteDB(id);
						if(num==1) System.out.println("Done!");
						else System.out.println("failed..");
					}
				}
			}
		}while(gubun != 0);
	}
}
