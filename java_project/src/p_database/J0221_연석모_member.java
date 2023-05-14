package p_database;

import java.util.ArrayList;
import java.util.Scanner;

public class J0221_연석모_member {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0221_연석모_dao dao = new J0221_연석모_dao();
		ArrayList<J0221_연석모_dto> dtos = null;
		
		int gubun = 0;
		do {
			System.out.print("검색 : 전체[1], 성명[2], 지역[3], 등록[4], 수정[5], 삭제[6], 종료[0] ");
			gubun = sc.nextInt();
			dtos = null;
			if(gubun == 1) {
				dtos = dao.selectDB("name","");
				dao.printArrList(dtos);
			}else if(gubun == 2) {
				System.out.print("검색할 문자열을 입력해주세요");
				String input = sc.next();
				dtos = dao.selectDB("name",input);
				dao.printArrList(dtos);
			}else if(gubun == 3) {
				System.out.print("검색할 문자열을 입력해주세요");
				String input = sc.next();
				dtos = dao.selectDB("area",input);
				dao.printArrList(dtos);
			}else if(gubun == 4) {
				int k = 0;
				J0221_연석모_dto dto = dao.getDtoList();
				if(dto != null) {
					k = dao.insertDB(dto);
					if(k == 1) System.out.println("Done!");
					else System.out.println("Failed..");
				}
			}else if(gubun == 5) {
				int k = 0;
				System.out.print("수정하고자 하는 id를 입력해주세요");
				String input = sc.next();
				if(input.length()!=3) System.out.println("ID를 잘못 입력하셨습니다.");
				else {
					dtos = dao.selectDB("id",input);
					dao.printArrList(dtos);
					if(dtos.size()!=0) {
						System.out.print("수정하시겠습니까?(Y/N)");
						String confirm = sc.next();
						if(confirm.equals("Y") || confirm.equals("y") || confirm.equals("ㅛ")) {
							System.out.print("얼마나 수정하시겠습니까? (전체[1] 일부분[2])");
							int temp = sc.nextInt();
							if(temp==1) {
								J0221_연석모_dto dto = dao.getDtoList(input);
								if(dto!=null) {
									k = dao.updateDB(dto);
									if(k == 1) System.out.println("Done!");
									else System.out.println("Failed..");
								}
							}else if(temp==2) {
								System.out.print("어느 항목을 수정하시겠습니까?(id / 성명 / 지역 / 나이)");
								String column = sc.next();
								column = dao.changeColumn(column);
								if(column.equals("오류")) {
									System.out.println("항목을 다시 입력해주세요");
								}else {
									System.out.print("어떤 값으로 수정하겠습니까?");
									String value = sc.next();
									k=dao.updateDB(input,column, value);
									if(k == 1) System.out.println("Done!");
									else System.out.println("Failed..");
								}
							}
							
						}else System.out.println("수정이 취소되었습니다.");
					}
				}
			}else if(gubun == 6) {
				int k = 0;
				System.out.println("삭제하고자 하는 id를 입력해주세요");
				String input = sc.next();
				if(input.length()!=3) System.out.println("ID를 잘못 입력하셨습니다.");
				else {
					dtos = dao.selectDB("id",input);
					dao.printArrList(dtos);
					if(dtos.size()!=0) {
						System.out.print("삭제하시겠습니까?(Y/N)");
						String confirm = sc.next();
						if(confirm.equals("Y") || confirm.equals("y") || confirm.equals("ㅛ")) {
							k = dao.deleteDB(input);
							if(k == 1) System.out.println("Done!");
							else System.out.println("Failed..");
						}else System.out.println("삭제가 취소되었습니다.");
					}
				}
			}
		}while(gubun != 0);
		System.out.println("프로그램이 종료됩니다.");
	}
}
