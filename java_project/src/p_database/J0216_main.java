package p_database;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class J0216_main {

//	executeQuery method는 오직 select - return값을 받을 필요가 있을 때만 실행.
//	나머지 update, insert, delete는  ececuteUpdate 사용
//	executeUpdate 는 return을 변경된 행의 수, 즉 int 값으로 return 한다 ( long으로 return 받기도 함. )
	
	
	public static void main(String[] args) {
		J0216_student_dao dao = new J0216_student_dao();
		Scanner sc = new Scanner(System.in);
		ArrayList<J0216_student_dto> arr = new ArrayList<>();
		String column="", value ="";
		
		String query = "select * from e_연석모_student";
		
		arr = dao.getStudent(query);
		dao.printArrList(arr);
		

		ArrayList<J0216_student_dto> dtos = new ArrayList<>();
		int gubun = 0;
		do {
			System.out.print("검색 전체[1], ID[2], 성명[3], 등록[4], 수정[5], 삭제[6], 종료[0]");
			gubun = sc.nextInt();
			if(gubun == 1) {
				dtos = dao.getSearchList("id","");
				dao.printArrList(dtos);
			}	
			else if(gubun == 2) {
				System.out.print("ID?");
				String id = sc.next();
				dtos = dao.getSearchList("id", id);
				dao.printArrList(dtos);
			}
			else if(gubun == 3) {
				System.out.print("성명?");
				String name = sc.next();
				dtos = dao.getSearchList("name", name);
				dao.printArrList(dtos);
			}
			else if(gubun == 4) {
				System.out.print("id?");
				String id = sc.next();
				if(id.length()!=3) {
					System.out.println("ID는 3자리로 입력해주세요");
					continue;
				}
				System.out.print("성명?");
				String name = sc.next();
				if(name.length()>5) {
					System.out.println("성함은 5자리 이내로 입력해주세요");
					continue;
				}
				int kor=0, eng=0, mat=0;
				System.out.print("국어점수?");
				kor = dao.inputNum();
				if(kor==-1) continue;
				System.out.print("영어점수?");
				eng = dao.inputNum();
				if(eng==-1) continue;
				System.out.print("수학점수?");
				mat = dao.inputNum();
				if(mat==-1) continue;
				int total = kor+eng+mat;
				String result = dao.getResult(total);
				
				J0216_student_dto dto = new J0216_student_dto(id,name,kor,eng,mat,total,result);
				
				int sum = dao.insertDB(dto);
				if(sum!=0) System.out.println("Done!");
				else System.out.println("Failed..");
			}
			else if(gubun == 5) {
				System.out.print("수정하고자 하는 column의 ID?");
				String id = sc.next();
				if(id.length()!=3) {
					System.out.println("id를 정확히 입력해주세요");
				}else {
					J0216_student_dto dto = dao.getStudentInfo(id);
					dao.printDto(dto);
					System.out.println("얼마나 수정 하시겠습니까? (일부 : 1 / 전체 : 2 / 안함 : 0)");
					int temp = sc.nextInt();
					if(temp==1) {
						System.out.print("수정하고자 하는 column명을 입력하세요");
						String column1 = sc.next();
						switch (column1) {
							case "이름" : case "dlfma":
								column1 = "name";
								break;
							case "국어" : case "rnrdj":
								column1 = "kor";
								break;
							case "영어" : case "duddj":
								column1 = "eng";
								break;
							case "수학" : case "tngkr":
								column1 = "mat";
								break;
							case "총점" : case "chdwja":
								column1 = "total";
								break;
							case "결과" : case "rufrhk":
								column1 = "result";
								break;
						}
						System.out.print("값을 입력하세요");
						String data = sc.next();
						int result = dao.updateDB(id, column1 , data);
						if(result!=0) System.out.println("Done!");
						else System.out.println("Failed..");
					}if(temp==2) {
						System.out.print("성명?");
						String name = sc.next();
						if(name.length()>5) {
							System.out.println("성함은 5자리 이내로 입력해주세요");
							continue;
						}
						int kor=0, eng=0, mat=0;
						System.out.print("국어점수?");
						kor = dao.inputNum();
						if(kor==-1) continue;
						System.out.print("영어점수?");
						eng = dao.inputNum();
						if(eng==-1) continue;
						System.out.print("수학점수?");
						mat = dao.inputNum();
						if(mat==-1) continue;
						int total = kor+eng+mat;
						String result = dao.getResult(total);
						
						J0216_student_dto dto1 = new J0216_student_dto(id,name,kor,eng,mat,total,result);
						
						int sum = dao.updateStudent(dto1);
						if(sum!=0) System.out.println("Done!");
						else System.out.println("Failed..");
					}
				}
			}
			else if(gubun == 6) {
				System.out.print("삭제 하고자 하는 ID?");
				String id = sc.next();
				J0216_student_dto dto = dao.getStudentInfo(id);
				dao.printDto(dto);
				System.out.print("정말 삭제? (Y/N)");
				switch (sc.next()) {
				case"Y": case"y": case"ㅛ":
					int result = dao.deleteDB(id);
					if(result!=0) System.out.println("Done!");
					else System.out.println("Failed..");
					break;
				default :
				}
				
			}
		}while(gubun != 0);
		System.out.println("프로그램을 종료합니다.");
	}
}
