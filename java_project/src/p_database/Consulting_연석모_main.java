package p_database;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consulting_연석모_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Consulting_연석모_dao dao= new Consulting_연석모_dao();
		Cstudent_연석모_dao sDao = new Cstudent_연석모_dao();
		Cmentor_연석모_dao mDao = new Cmentor_연석모_dao();
		
		
		String gubun = "";
		int sGubun = 0;
		
		do {
			System.out.print("[S]학생 관리, [M]멘토 관리, [C]상담 관리, [Q]종료");
			gubun = dao.selectGubun(sc.next());
			if(gubun.equalsIgnoreCase("S")) {
				do {
				System.out.print("전체 조회[1], 등록[2], 수정[3], 삭제[4], 뒤로[0]");
				sGubun = sc.nextInt();
				if(sGubun == 1) {
					ArrayList<Cstudent_연석모_dto> arr = sDao.selectAllDB();
					sDao.printArrList(arr);
				}else if(sGubun == 2) {
					Cstudent_연석모_dto dto = sDao.getStudentInfo();
					if(dto==null) System.out.println("처음으로 되돌아갑니다.");
					else {
						
						int k = sDao.insertDB(dto);
						dao.getResult(k);
					}
				}else if(sGubun == 3) {
					System.out.println("얼마나 수정하시겠습니까? (전체[1], 일부[2], 취소[0])");
					int ssGubun = sc.nextInt();
					if(ssGubun==1) {
						ArrayList<Cstudent_연석모_dto> arr = sDao.selectAllDB();
						sDao.printArrList(arr);
						System.out.println("어느 학생 번호를 수정하시겠습니까?(S를 제외하고 입력)");
						String inputId = sc.next();
						inputId = "S"+inputId;
						if(sDao.confirmId(inputId)==0) {
							System.out.println("학생 번호를 잘못 입력하셨습니다.");
						}else {
							Cstudent_연석모_dto dto = sDao.getStudentInfo(inputId);
							if(dto==null) System.out.println("처음으로 되돌아갑니다.");
							else {
								int k = sDao.updateDB(dto);
								dao.getResult(k);
							}
						}
					}else if(ssGubun==2) {
						ArrayList<Cstudent_연석모_dto> arr = sDao.selectAllDB();
						sDao.printArrList(arr);
						System.out.println("어느 학생 번호를 수정하시겠습니까?(S를 제외하고 입력)");
						String inputId = sc.next();
						inputId = "S"+inputId;
						if(sDao.confirmId(inputId)==0) {
							System.out.println("학생 번호를 잘못 입력하셨습니다.");
						}else {
							System.out.println("어느 항목을 수정하시겠습니까?(성함:1 / 나이:2)");
							int temp = sc.nextInt();
							if(temp == 1) {
								System.out.println("어떤 값으로 수정하시겠습니까?");
								String input = sc.next();
								int k = sDao.updateDB("name",input,inputId);
								dao.getResult(k);
							}
							else if(temp == 2) {
								System.out.println("어떤 값으로 수정하시겠습니까?");
								String input = sc.next();
								int k = sDao.updateDB("age",input,inputId);
								dao.getResult(k);
							}
							else {
								System.out.println("수정할 항목을 정확히 입력해주세요.");
							}
						}
					}else System.out.println("처음으로 되돌아갑니다.");
				}else if(sGubun == 4) {
					ArrayList<Cstudent_연석모_dto> arr = sDao.selectAllDB();
					sDao.printArrList(arr);
					System.out.println("어떤 학생 정보를 삭제하시겠습니까? (멘토 번호 S를 제외하고 입력)");
					String inputId = sc.next();
					inputId = "S"+inputId;
					if(sDao.confirmId(inputId)==0) {
						System.out.println("학생 번호를 잘못 입력하셨습니다.");
					}else if(dao.confirmId("sid", inputId)>0) {
						System.out.println("상담 내역에서 사용중인 학생 정보입니다.");
					}
					else {
						System.out.println("정말로 삭제하시겠습니까? (y/n)");
						String cInput = sc.next();
						if(cInput.equalsIgnoreCase("y")||cInput.equals("ㅛ")) {
							int k = sDao.deleteDB(inputId);
							dao.getResult(k);
						}
					}
				}else if(sGubun == 0) {
					System.out.println("뒤로 돌아갑니다.");
				}
				}while(sGubun!=0);
			}else if(gubun.equalsIgnoreCase("M")) {
				do {
					System.out.print("전체 조회[1], 등록[2], 수정[3], 삭제[4], 뒤로[0]");
					sGubun = sc.nextInt();
					if(sGubun == 1) {
						ArrayList<Cmentor_연석모_dto> arr = mDao.selectAllDB();
						mDao.printArrList(arr);
					}else if(sGubun == 2) {
						Cmentor_연석모_dto dto = mDao.getMentorInfo();
						if(dto==null) System.out.println("처음으로 되돌아갑니다.");
						else {
							
							int k = mDao.insertDB(dto);
							dao.getResult(k);
						}
					}else if(sGubun == 3) {
						ArrayList<Cmentor_연석모_dto> arr = mDao.selectAllDB();
						mDao.printArrList(arr);
						System.out.println("어느 멘토 번호를 수정하시겠습니까?(M을 제외하고 입력)");
						String inputId = sc.next();
						inputId = "M"+inputId;
						if(mDao.confirmId(inputId)==0) {
							System.out.println("멘토 번호를 잘못 입력하셨습니다.");
						}else {
							Cmentor_연석모_dto dto = mDao.getMentorInfo(inputId);
							if(dto==null) System.out.println("처음으로 되돌아갑니다.");
							else {
								int k = mDao.updateDB(dto);
								dao.getResult(k);
							}
						}
					}else if(sGubun == 4) {
						ArrayList<Cmentor_연석모_dto> arr = mDao.selectAllDB();
						mDao.printArrList(arr);
						System.out.println("어떤 멘토 정보를 삭제하시겠습니까? (멘토 번호 M을 제외하고 입력)");
						String inputId = sc.next();
						inputId = "M"+inputId;
						if(mDao.confirmId(inputId)==0) {
							System.out.println("멘토 번호를 잘못 입력하셨습니다.");
						}else if(dao.confirmId("mid", inputId)>0) {
							System.out.println("상담 내역에서 사용중인 멘토 정보입니다.");
						}else {
							System.out.println("정말로 삭제하시겠습니까? (y/n)");
							String cInput = sc.next();
							if(cInput.equalsIgnoreCase("y")||cInput.equals("ㅛ")) {
								int k = mDao.deleteDB(inputId);
								dao.getResult(k);
							}
						}
					}else if(sGubun == 0) {
						System.out.println("뒤로 돌아갑니다.");
					}
					}while(sGubun!=0);
				
			}else if(gubun.equalsIgnoreCase("C")) {
				do {
					System.out.print("전체 조회[1], 등록[2], 수정[3], 삭제[4], 뒤로[0]");
					sGubun = sc.nextInt();
					if(sGubun == 1) {
						ArrayList<Consulting_연석모_dto> arr = dao.selectAllDB();
						dao.printArrList(arr);
					}else if(sGubun == 2) {
						Consulting_연석모_dto dto = dao.getConsultInfo();
						if(dto==null) System.out.println("처음으로 되돌아갑니다.");
						else {
							
							int k = dao.insertDB(dto);
							dao.getResult(k);
						}
					}else if(sGubun == 3) {
						System.out.println("얼마나 수정하시겠습니까? (전체[1], 일부[2], 취소[0])");
						int ssGubun = sc.nextInt();
						if(ssGubun==1) {
							ArrayList<Consulting_연석모_dto> arr = dao.selectAllDB();
							dao.printArrList(arr);
							System.out.println("어느 상담 번호를 수정하시겠습니까?(C를 제외하고 입력)");
							String inputId = sc.next();
							inputId = "C"+inputId;
							if(dao.confirmId(inputId)==0) {
								System.out.println("상담 번호를 잘못 입력하셨습니다.");
							}else {
								Consulting_연석모_dto dto = dao.getConsultInfo(inputId);
								if(dto==null) System.out.println("처음으로 되돌아갑니다.");
								else {
									int k = dao.updateDB(dto);
									dao.getResult(k);
								}
							}
						}else if(ssGubun==2) {
							ArrayList<Consulting_연석모_dto> arr = dao.selectAllDB();
							dao.printArrList(arr);
							System.out.println("어느 상담 번호를 수정하시겠습니까?(C를 제외하고 입력)");
							String inputId = sc.next();
							inputId = "C"+inputId;
							if(dao.confirmId(inputId)==0) {
								System.out.println("상담 번호를 잘못 입력하셨습니다.");
							}else {
								System.out.println("어느 항목을 수정하시겠습니까?(학생 번호:1 / 멘토 번호:2 / 상담 일자:3 / 상담 내용:4)");
								int temp = sc.nextInt();
								if(temp == 1) {
									System.out.println("어떤 값으로 수정하시겠습니까?(S를 제외한 숫자 3자리 입력)");
									String input = sc.next();
									if(input.length()!=3) {
										System.out.println("3자리로 입력해주세요");
									}else {
										input="S"+input;
										if(sDao.confirmId(input)==0) {
											System.out.println("없는 학생번호 입니다.");
										}else {
											int k = dao.updateDB("sId",input,inputId);
											dao.getResult(k);
										}
									}
								}else if(temp == 2) {
									System.out.println("어떤 값으로 수정하시겠습니까?(M을 제외한 숫자 3자리 입력)");
									String input = sc.next();
									if(input.length()!=3) {
										System.out.println("3자리로 입력해주세요");
									}else {
										input="M"+input;
										if(mDao.confirmId(input)==0) {
											System.out.println("없는 멘토번호 입니다.");
										}else {
											int k = dao.updateDB("mId",input,inputId);
											dao.getResult(k);
										}
									}
								}else if(temp == 3) {
									try {
										System.out.print("상담 년도를 입력해주세요(숫자만)");
										int yy = sc.nextInt();
										System.out.print("상담한 달을 입력해주세요(숫자만)");
										int mm = sc.nextInt();
										if(mm>=1 && mm<=12) {
											System.out.print("상담한 일자를 입력해주세요(숫자만)");
											int dd = sc.nextInt();
											if(dao.confirmDate(yy,mm,dd)) {
												String cDate = yy+"-"+mm+"-"+dd;
												int k = dao.updateDB("cDate",cDate,inputId);
												dao.getResult(k);
											}
										}else {
											System.out.println("달은 1월부터 12월까지 입니다.");
										}
									}catch(InputMismatchException e) {
										System.out.println("날짜는 숫자만 입력해주세요");
									}
								}else if(temp == 4) {
									System.out.print("새로운 상담내용을 입력해주세요.");
									String cContent = sc.nextLine();
									cContent = sc.nextLine();
									int k = dao.updateDB("cContent", cContent, inputId);
									dao.getResult(k);
								}else{
									System.out.println("수정할 항목을 정확히 입력해주세요.");
								}
							}
						}else System.out.println("처음으로 되돌아갑니다.");
					}else if(sGubun == 4) {
						ArrayList<Consulting_연석모_dto> arr = dao.selectAllDB();
						dao.printArrList(arr);
						System.out.println("어떤 상담 정보를 삭제하시겠습니까? (상담 번호 C를 제외하고 입력)");
						String inputId = sc.next();
						inputId = "C"+inputId;
						if(dao.confirmId(inputId)==0) {
							System.out.println("상담 번호를 잘못 입력하셨습니다.");
						}else {
							System.out.println("정말로 삭제하시겠습니까? (y/n)");
							String cInput = sc.next();
							if(cInput.equalsIgnoreCase("y")||cInput.equals("ㅛ")) {
								int k = dao.deleteDB(inputId);
								dao.getResult(k);
							}
						}
					}else if(sGubun == 0) {
						System.out.println("뒤로 돌아갑니다.");
					}
				}while(sGubun!=0);
			}else if(gubun.equalsIgnoreCase("K")) {
				int k=dao.commit();
				System.out.println();
			}
		}while(!gubun.equalsIgnoreCase("Q"));
//				equalsIgnoreCase는 대소문자를 구분하지 않고 비교를 해서 boolean으로 return 한다.
		System.out.println("프로그램을 종료합니다.");
	}
}
