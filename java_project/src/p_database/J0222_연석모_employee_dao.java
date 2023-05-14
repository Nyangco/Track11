package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class J0222_연석모_employee_dao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	
	public int searchDB(String input) {
		int k = 0;
		String query = "select count(*) as count from e_연석모_employee where id ='"+input+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				k = rs.getInt("count");
			}
		}catch(SQLException e) {
			System.out.println("Query :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}

	public ArrayList<J0222_연석모_employee_dto> selectDB(String column, String inputId) {
		ArrayList<J0222_연석모_employee_dto> arr = new ArrayList<>();
		String query = 
		"select e.id, e.name, e.depart, d.depart_ccode, e.rank, r.rank_code, age"+
		" from e_연석모_employee e, commondepart d, commonrank r"+
		" where e.depart = d.depart_ccode"+
		" and e.rank = r.rank_code"+
		" and e."+column+" like '%"+inputId+"%'"+
		" order by id desc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String depart = rs.getString("depart");
				String rank = rs.getString("rank");
				int age = rs.getInt("age");
				
				arr.add(new J0222_연석모_employee_dto(id,name,depart,rank,age));
			}
		}catch(SQLException e) {
			System.out.println("Query :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}

	public void printArrList(ArrayList<J0222_연석모_employee_dto> arr) {
		System.out.println("===================================");
		System.out.println("사번\t성명\t부서\t직위\t나이");
		System.out.println("-----------------------------------");
		for(int k=0; k<arr.size(); k++) {
			System.out.print(arr.get(k).getId()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.print(arr.get(k).getRank()+"\t");
			System.out.print(arr.get(k).getAge()+"\n");
		}System.out.println("-----------------------------------");
		System.out.println("총원 : "+arr.size()+"명");
		System.out.println("===================================");
	}
	
	public J0222_연석모_employee_dto getDto(String check) {
		J0222_연석모_employee_dto dto = null;
		
		System.out.print("사번?");
		String id = sc.next();
		if(searchDB(id)==0 || id.equals(check)) {
			System.out.print("성명?");
			String name = sc.next();
			System.out.print("부서? (총무:10, 인사:20, 영업:30, 재무:40)");
			String depart = sc.next();
			if(depart.equals("10") || depart.equals("20") || depart.equals("30") || depart.equals("40")) {
				System.out.print("직위? (사원:A, 대리:B, 과장:C, 부장:D)");
				String rank = sc.next();
				if(rank.equals("a"))rank="A";
				else if(rank.equals("b"))rank="B";
				else if(rank.equals("c"))rank="C";
				else if(rank.equals("d"))rank="D";
				else {
					System.out.println("직위 선택 오류");
					return dto;
				}
				System.out.print("나이?");
				int age = sc.nextInt();
				
				dto = new J0222_연석모_employee_dto(id,name,depart,rank,age);
			}
		}
		else {
			System.out.println("이미 있는 id");
		}
		return dto;
	}

	public J0222_연석모_employee_dto getDto() {
		J0222_연석모_employee_dto dto = null;
		
		System.out.print("사번?");
		String id = sc.next();
		if(searchDB(id)!=0) System.out.println("이미 있는 id");
		else {
			System.out.print("성명?");
			String name = sc.next();
			System.out.print("부서? (총무:10, 인사:20, 영업:30, 재무:40)");
			String depart = sc.next();
			if(depart.equals("10") || depart.equals("20") || depart.equals("30") || depart.equals("40")) {
				System.out.print("직위? (사원:A, 대리:B, 과장:C, 부장:D)");
				String rank = sc.next();
				if(rank.equals("a"))rank="A";
				else if(rank.equals("b"))rank="B";
				else if(rank.equals("c"))rank="C";
				else if(rank.equals("d"))rank="D";
				else {
					System.out.println("직위 선택 오류");
					return dto;
				}
				System.out.print("나이?");
				int age = sc.nextInt();
				
				dto = new J0222_연석모_employee_dto(id,name,depart,rank,age);
			}else {
				System.out.println("부서 선택 오류");
			}
		}
		return dto;
	}

	public int insertDB(J0222_연석모_employee_dto dto) {
		int k = 0;
		String query = "insert into e_연석모_employee (id,name,depart,rank,age) values('"+
						dto.getId()+"', '"+
						dto.getName()+"', '"+
						dto.getDepart()+"', '"+
						dto.getRank()+"', "+
						dto.getAge()+")";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Query :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}

	public int updateDB(String id, J0222_연석모_employee_dto dto) {
		int k = 0;
		String query = "update e_연석모_employee"+
						" set id = '"+dto.getId()+
						"', name = '"+dto.getName()+
						"', depart = '"+dto.getDepart()+
						"', rank = '"+dto.getRank()+
						"', age = "+dto.getAge()+
						" where id = '"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Query :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}

	public int updateDB(String id, String column, String value) {
		int k = 0;
		String query = "update e_연석모_employee"+
						" set "+column+" = '"+value+"'"+
						" where id = '"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Query :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}

	public String getColumn(int input) {
		if(input==2) return "name";
		else if(input==3) return "depart";
		else if(input==4) return "rank";
		else if(input==5) return "age";
		else return "error";
	}

	public int deleteDB(String id) {
		int k = 0;
		String query = "delete from e_연석모_employee where id = '"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Query :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}

	

}
