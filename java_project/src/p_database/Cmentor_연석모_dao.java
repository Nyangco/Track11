package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cmentor_연석모_dao {
	Scanner sc = new Scanner(System.in);
	Connection con;
	PreparedStatement ps;
	ResultSet rs;


	public Cmentor_연석모_dto getMentorInfo(String inputId) {
		Cmentor_연석모_dto dto = null;
		System.out.print("성명을 입력하세요");
		String name = sc.next();
		if(name.length()<1 || name.length()>5) {
			System.out.println("성명을 잘못 입력하셨습니다. 1자리부터 5자리 사이로 입력해주세요");
		}else dto = new Cmentor_연석모_dto(inputId,name);
		return dto;
	}
	
	public Cmentor_연석모_dto getMentorInfo() {
		Cmentor_연석모_dto dto = null;
		System.out.print("멘토 번호를 입력해주세요");
		String mId = sc.next();
		if(mId.length()!=3) {
			System.out.println("ID는 3자리로 입력되어야 합니다.");
		}else {
			mId="M"+mId;
			if(confirmId(mId)==1) {
				System.out.println("중복된 멘토 번호 입니다.");
			}else {
				System.out.print("성명을 입력하세요");
				String name = sc.next();
				if(name.length()<1 || name.length()>5) {
					System.out.println("성명을 잘못 입력하셨습니다. 1자리부터 5자리 사이로 입력해주세요");
				}else {
					dto = new Cmentor_연석모_dto(mId,name);
				}
			}
		}
		return dto;
	}

	int confirmId(String mId) {
		int k = 0;
		String query = "select count(*) from e_연석모_mentor where  mid= '"+mId+"'";
		
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

	public int insertDB(Cmentor_연석모_dto dto) {
		int k = 0;
		String sql = "insert into e_연석모_mentor (mid, name) values ('"+
					dto.getmId()+"','"+dto.getName()+"')";
		
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

	public ArrayList<Cmentor_연석모_dto> selectAllDB() {
		ArrayList<Cmentor_연석모_dto> arr = new ArrayList<>();
		String sql = "select mid, name from e_연석모_mentor order by mid desc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String mId = rs.getString("mId");
				String name = rs.getString("name");
				Cmentor_연석모_dto dto = new Cmentor_연석모_dto(mId,name);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("Query :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return arr;
	}

	public void printArrList(ArrayList<Cmentor_연석모_dto> arr) {
		System.out.println("=====================");
		System.out.println("총원 :"+arr.size()+"명");
		System.out.println("---------------------");
		System.out.println("멘토 번호\t성명");
		System.out.println("---------------------");
		if(arr.size()==0) {
			System.out.println("자료가 없습니다.");
		}else {
			for(int k = 0; k<arr.size(); k++) {
				System.out.print(arr.get(k).getmId()+"\t");
				System.out.print(arr.get(k).getName()+"\n");
			}
		}System.out.println("---------------------");
	}

	public int updateDB(Cmentor_연석모_dto dto) {
		int k = 0;
		String sql = "update e_연석모_mentor set name ='"+dto.getName()+
				"' where mid = '"+dto.getmId()+"'";
		
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
		String sql = "delete e_연석모_mentor where mid = '"+inputId+"'";
		
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
