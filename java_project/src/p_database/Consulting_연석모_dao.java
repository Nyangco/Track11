package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consulting_연석모_dao {
	
	Scanner sc = new Scanner(System.in);
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	String selectGubun(String gubun) {
		switch(gubun) {
		case"S": case"s": case"ㄴ":
			return "S";
		case"M": case"m": case"ㅡ":
			return "M";
		case"C": case"c": case"ㅊ":
			return "C";
		case"Q": case"q": case"ㅂ":
			return "Q";
		case"K": case"k": case"ㅏ":
			return "K";
		default:
			System.out.println("잘못 입력하셨습니다.");
			return "";
		}
	}

	public void getResult(int k) {
		if(k==1)System.out.println("Done!");
		else if(k==0)System.out.println("Failed..");
		else System.out.println("Critical Miss!");
	}

	public Consulting_연석모_dto getConsultInfo(String inputId) {
		Consulting_연석모_dto dto = null;
		Cstudent_연석모_dao sDao = new Cstudent_연석모_dao();
		Cmentor_연석모_dao mDao = new Cmentor_연석모_dao();
		System.out.print("학생 번호를 입력해주세요(S를 제외한 숫자 3자리)");
		String sId = sc.next();
		if(sId.length()!=3) {
			System.out.println("S를 제외한 숫자 3자리로 입력해주세요");
		}else {
			sId="S"+sId;
			if(sDao.confirmId(sId)==0) {
				System.out.println("없는 학생번호 입니다");
			}else {
				System.out.print("멘토 번호를 입력해주세요(M를 제외한 숫자 3자리)");
				String mId = sc.next();
				if(mId.length()!=3) {
					System.out.println("M를 제외한 숫자 3자리로 입력해주세요");
				}else {
					mId="M"+mId;
					if(mDao.confirmId(mId)==0) {
						System.out.println("없는 멘토번호입니다.");
					}
					else {
						try {
							System.out.print("상담 년도를 입력해주세요(숫자만)");
							int yy = sc.nextInt();
							System.out.print("상담한 달을 입력해주세요(숫자만)");
							int mm = sc.nextInt();
							if(mm>=1 && mm<=12) {
								System.out.print("상담한 일자를 입력해주세요(숫자만)");
								int dd = sc.nextInt();
								if(confirmDate(yy,mm,dd)) {
									String cDate = yy+"-"+mm+"-"+dd;
									System.out.println("상담 내용을 입력해주세요.");
									String cContent = sc.next();
									dto = new Consulting_연석모_dto(inputId,sId,mId,cDate,cContent);
								}
							}else {
								System.out.println("달은 1월부터 12월까지 입니다.");
							}
						}catch(InputMismatchException e) {
							System.out.println("날짜는 숫자만 입력해주세요");
						}
					}
				}
			}
		}
		return dto;
	}
	
	public boolean confirmDate(int yy, int mm, int dd) {
		switch (mm) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			if(dd>=1 && dd<=31) return true;
		case 4: case 6: case 9: case 11:
			if(dd>=1 && dd<=30) return true;
		case 2:
			if(dd>=1 && dd<=28) return true;
		default:
			if(yy%4==0 && mm==2 && dd==29) return true;
			System.out.println("입력한 날짜를 확인해주세요");
			return false;
		}
	}

	public Consulting_연석모_dto getConsultInfo() {
		Consulting_연석모_dto dto = null;
		Cstudent_연석모_dao sDao = new Cstudent_연석모_dao();
		Cmentor_연석모_dao mDao = new Cmentor_연석모_dao();
		System.out.print("상담 번호를 입력해주세요(C를 제외한 숫자 3자리)");
		String cId = sc.next();
		if(cId.length()!=3) {
			System.out.println("C를 제외한 숫자 3자리로 입력해주세요.");
		}else {
			cId="C"+cId;
			if(confirmId(cId)==1) {
				System.out.println("중복된 상담 번호 입니다.");
			}else {
				System.out.print("학생 번호를 입력해주세요(S를 제외한 숫자 3자리)");
				String sId = sc.next();
				if(sId.length()!=3) {
					System.out.println("S를 제외한 숫자 3자리로 입력해주세요");
				}else {
					sId="S"+sId;
					if(sDao.confirmId(sId)==0) {
						System.out.println("없는 학생번호 입니다");
					}else {
						System.out.print("멘토 번호를 입력해주세요(M를 제외한 숫자 3자리)");
						String mId = sc.next();
						if(mId.length()!=3) {
							System.out.println("M를 제외한 숫자 3자리로 입력해주세요");
						}else {
							mId="M"+mId;
							if(mDao.confirmId(mId)==0) {
								System.out.println("없는 멘토번호입니다.");
							}
							else {
								try {
									System.out.print("상담 년도를 입력해주세요(숫자만)");
									int yy = sc.nextInt();
									if(yy > 2023) {
										System.out.println("상담 년도는 2023년보다 클 수 없습니다.");
									}
									System.out.print("상담한 달을 입력해주세요(숫자만)");
									int mm = sc.nextInt();
									if(mm>=1 && mm<=12) {
										System.out.print("상담한 일자를 입력해주세요(숫자만)");
										int dd = sc.nextInt();
										if(confirmDate(yy,mm,dd)) {
											String cDate = yy+"-"+mm+"-"+dd;
											System.out.println("상담 내용을 입력해주세요.");
											String cContent = sc.nextLine();
											cContent = sc.nextLine();
											dto = new Consulting_연석모_dto(cId,sId,mId,cDate,cContent);
										}
									}else {
										System.out.println("달은 1월부터 12월까지 입니다.");
									}
								}catch(InputMismatchException e) {
									System.out.println("날짜는 숫자만 입력해주세요");
								}
								
							}
						}
					}
				}
			}
		}
		return dto;
	}
	
	int confirmId(String column, String value) {
		int k = 0;
		String sql = "select count(*) from e_연석모_consulting where "+column+" = '"+value+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				k = rs.getInt(1);
			}
		}catch(SQLException e) {
			System.out.println("Query : "+sql);
			e.printStackTrace();
			
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}

	int confirmId(String cId) {
		int k = 0;
		String query = "select count(*) from e_연석모_consulting where no = '"+cId+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				k = rs.getInt(1);
			}
		}catch(SQLException e) {
			System.out.println("Query : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}

	public int insertDB(Consulting_연석모_dto dto) {
		int k = 0;
		String sql = "insert into e_연석모_consulting (no, sId, mId, cDate, cContent) values ('"+
					dto.getNo()+"','"+dto.getsId()+"','"+dto.getmId()+"','"+dto.getcDate()+"', '"+dto.getcContent()+"')";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Query :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}

	public ArrayList<Consulting_연석모_dto> selectAllDB() {
		ArrayList<Consulting_연석모_dto> arr = new ArrayList<>();
		String sql = "select e.no,e.sid,s.name as sname,s.age,e.mid,m.name as mname,e.cdate,e.cContent from e_연석모_consulting e, e_연석모_educatee s, e_연석모_mentor m"+
					" where e.sid=s.sid and e.mid=m.mid order by no desc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("no");
				String sId = rs.getString("sid");
				String sName = rs.getString("sname");
				int sAge = rs.getInt("age");
				String mId = rs.getString("mid");
				String mName = rs.getString("mname");
				String cDate = rs.getString("cDate");
				cDate = cDate.substring(0, 10);
				String cContent = rs.getString("cContent");
				Consulting_연석모_dto dto = new Consulting_연석모_dto(no, sId, sName, mId, mName, cDate, cContent, sAge);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("Query :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return arr;
	}

	public void printArrList(ArrayList<Consulting_연석모_dto> arr) {
		System.out.println("=======================================================================================================");
		System.out.println("총 상담 수 :"+arr.size()+"건");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("상담 번호\t학생 번호\t학생 성명\t학생 나이\t멘토 번호\t멘토 성명\t상담 일자\t\t상담 내용");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		if(arr.size()==0) {
			System.out.println("자료가 없습니다.");
		}else {
			for(int k = 0; k<arr.size(); k++) {
				System.out.print(arr.get(k).getNo()+"\t");
				System.out.print(arr.get(k).getsId()+"\t");
				System.out.print(arr.get(k).getsName()+"\t");
				System.out.print(arr.get(k).getsAge()+"\t");
				System.out.print(arr.get(k).getmId()+"\t");
				System.out.print(arr.get(k).getmName()+"\t");
				System.out.print(arr.get(k).getcDate()+"\t");
				System.out.print(arr.get(k).getcContent()+"\n");
			}
		}System.out.println("=======================================================================================================");
	}

	public int updateDB(Consulting_연석모_dto dto) {
		int k = 0;
		String sql = "update e_연석모_consulting set sId ='"+dto.getsId()+
				"', mId = '"+dto.getmId()+"', cDate = '"+dto.getcDate()+"' where no = '"+dto.getNo()+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Query :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}

	public int updateDB(String column, String value, String inputId) {
		int k = 0;
		String sql = "update e_연석모_consulting set "+column+" ='"+value+"'"+
						"where no = '"+inputId+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Query :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}

	public int deleteDB(String inputId) {
		int k = 0;
		String sql = "delete e_연석모_consulting where no = '"+inputId+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Query :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}

	public int commit() {
		int k = 0;
		String sql = "commit";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Query :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}

}
