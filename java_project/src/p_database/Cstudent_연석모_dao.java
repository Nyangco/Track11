package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cstudent_연석모_dao {
	
	Scanner sc = new Scanner(System.in);
	Connection con;
	PreparedStatement ps;
	ResultSet rs;


	public Cstudent_연석모_dto getStudentInfo(String inputId) {
		Cstudent_연석모_dto dto = null;
		System.out.print("성명을 입력하세요");
		String name = sc.next();
		if(name.length()<1 || name.length()>5) {
			System.out.println("성명을 잘못 입력하셨습니다. 1자리부터 5자리 사이로 입력해주세요");
		}else {
			System.out.println("나이를 입력하세요");
			int age = sc.nextInt();
			if(age<0 || age>180) {
				System.out.println("나이를 잘못 입력하셨습니다. 0~180 사이로 입력해주세요.");
			}else {
				dto = new Cstudent_연석모_dto(inputId,name,age);
			}
		}
		return dto;
	}
	
	public Cstudent_연석모_dto getStudentInfo() {
		Cstudent_연석모_dto dto = null;
		System.out.print("학생 번호를 S를 제외한 숫자 3자리로 입력해주세요.");
		String sId = sc.next();
		if(sId.length()!=3) {
			System.out.println("ID는 3자리로 입력되어야 합니다.");
		}else {
			sId="S"+sId;
			if(confirmId(sId)==1) {
				System.out.println("중복된 학생 번호 입니다.");
			}else {
				System.out.print("성명을 입력하세요");
				String name = sc.next();
				if(name.length()<1 || name.length()>5) {
					System.out.println("성명을 잘못 입력하셨습니다. 1자리부터 5자리 사이로 입력해주세요");
				}else {
					System.out.println("나이를 입력하세요");
					int age = sc.nextInt();
					if(age<0 || age>180) {
						System.out.println("나이를 잘못 입력하셨습니다. 0~180 사이로 입력해주세요.");
					}else {
						dto = new Cstudent_연석모_dto(sId,name,age);
					}
				}
			}
		}
		return dto;
	}

	int confirmId(String sId) {
		int k = 0;
		String query = "select count(*) from e_연석모_educatee where sid= '"+sId+"'";
		
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

	public int insertDB(Cstudent_연석모_dto dto) {
		int k = 0;
		String sql = "insert into e_연석모_educatee (sid, name, age) values ('"+
					dto.getsId()+"','"+dto.getName()+"',"+dto.getAge()+")";
		
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

	public ArrayList<Cstudent_연석모_dto> selectAllDB() {
		ArrayList<Cstudent_연석모_dto> arr = new ArrayList<>();
		String sql = "select sid, name, age from e_연석모_educatee order by sid desc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String sId = rs.getString("sId");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Cstudent_연석모_dto dto = new Cstudent_연석모_dto(sId,name,age);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("Query :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return arr;
	}

	public void printArrList(ArrayList<Cstudent_연석모_dto> arr) {
		System.out.println("=====================");
		System.out.println("총원 :"+arr.size()+"명");
		System.out.println("---------------------");
		System.out.println("학생 번호\t성명\t나이");
		System.out.println("---------------------");
		if(arr.size()==0) {
			System.out.println("자료가 없습니다.");
		}else {
			for(int k = 0; k<arr.size(); k++) {
				System.out.print(arr.get(k).getsId()+"\t");
				System.out.print(arr.get(k).getName()+"\t");
				System.out.print(arr.get(k).getAge()+"\n");
			}
		}System.out.println("---------------------");
	}

	public int updateDB(Cstudent_연석모_dto dto) {
		int k = 0;
		String sql = "update e_연석모_educatee set name ='"+dto.getName()+
				"', age = "+dto.getAge()+" where sid = '"+dto.getsId()+"'";
		
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
		String sql = "update e_연석모_educatee set "+column+" ='"+value+"'"+
						" where sid = '"+inputId+"'";
		
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
		String sql = "delete e_연석모_educatee where sid = '"+inputId+"'";
		
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

}
