package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class J0221_연석모_dao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	ArrayList<J0221_연석모_dto> dtos = null;
	
	void printDto(J0221_연석모_dto dto) {
		System.out.print(dto.getId()+"\t");
		System.out.print(dto.getName()+"\t");
		System.out.print(dto.getArea()+"\t");
		System.out.print(dto.getAge()+"\n");
	}
	
	void printIndex() {
		System.out.println("===========================");
		System.out.println("ID\t성함\t지역\t나이");
		System.out.println("---------------------------");
	}

	void printArrList(ArrayList<J0221_연석모_dto> dtos) {
		System.out.println("---------------------------");
		System.out.println("총인원 :"+dtos.size());
		printIndex();
		if(dtos.size()==0) System.out.println("해당 인원 없음");
		else {
			for(int k=0; k<dtos.size(); k++) {
				printDto(dtos.get(k));
			}
		}
		System.out.println("===========================");
	}

	public ArrayList<J0221_연석모_dto> selectDB(String column, String value) {
		ArrayList<J0221_연석모_dto> dtos = new ArrayList<>();
		String query = "select id, name, area, age"+
						" from e_연석모_member "+
						" where "+column+" like '%"+value+"%'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String area = rs.getString("area");
				if(area==null) area="";
				int age = rs.getInt("age");
				J0221_연석모_dto dto = new J0221_연석모_dto(id,name,area,age);
				dtos.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("Query : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	public J0221_연석모_dto getDtoList() {
		int k = 0;
		J0221_연석모_dto dto = null;
		System.out.print("ID?");
		String id = sc.next();
		
		dtos = selectDB("id",id);
		if(dtos != null) {
			System.out.println("중복된 ID입니다.");
		}else {
			if(id.length()!=3) {
				System.out.println("ID는 3자리여야 합니다.");
			}
			else {
			System.out.print("성함?");
			String name = sc.next();
			if(name.length()>5) {
				System.out.println("이름이 너무 깁니다");
			}else {
					System.out.print("지역?");
					String area = sc.next();
					if(area.length()>5 || area.length()<1) {
						System.out.println("지역명이 부적합합니다.");
					}else {
						System.out.print("나이?");
						int age = sc.nextInt();
						if(age>180 || age<0) {
							System.out.println("나이를 잘못 입력하셨습니다.");
						}else {
							dto = new J0221_연석모_dto(id,name,area,age);
							return dto;
						}
					}
				}
			}
		}
		return null;
	}
	
	public J0221_연석모_dto getDtoList(String id) {
		J0221_연석모_dto dto = null;
		System.out.print("성함?");
		String name = sc.next();
		if(name.length()>5) {
			System.out.println("이름이 너무 깁니다");
		}else {
			System.out.print("지역?");
			String area = sc.next();
			if(area.length()>5 || area.length()<1) {
				System.out.println("지역명이 부적합합니다.");
			}else {
				System.out.print("나이?");
				int age = sc.nextInt();
				if(age>180 || age<0) {
					System.out.println("나이를 잘못 입력하셨습니다.");
				}else {
					dto = new J0221_연석모_dto(id,name,area,age);
					return dto;
				}
			}
		}
		return null;
	}
	

	public int insertDB(J0221_연석모_dto dto) {
		int k = 0;
		String query = "insert into e_연석모_member"+
						" values('"+dto.getId()+"','"+dto.getName()+"','"+
						dto.getArea()+"',"+dto.getAge()+")";
		
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
	
	public int updateDB(String id, String column, String value) {
		int k=0;
		String query = "update e_연석모_member"+
					" set "+column+" = '"+value+
					"' where id ='"+id+"'";
		
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

	public int updateDB(J0221_연석모_dto dto) {
		int k = 0;
		String query = "update e_연석모_member"+
						" set name = '"+dto.getName()+
						"', area = '"+dto.getArea()+
						"', age ="+dto.getAge()+
						" where id ='"+dto.getId()+"'";
		
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

	public int deleteDB(String id) {
		int k = 0;
		String query = "delete from e_연석모_member"+
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

	public String changeColumn(String column) {
		switch (column) {
		case"id": case"ID": case"아이디":
			column = "id";
			break;
		case"성함": case"이름": case"name":
			column = "name";
			break;
		case"지역": case"area":
			column = "area";
			break;
		case"나이": case"연세": case"age":
			column = "age";
			break;
		default:
			column="오류";
		}
		return column;
	}

	
}
