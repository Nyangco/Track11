package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.Member_dto;

public class Member_dao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int MemberSave(Member_dto dto) {
		int result = 0;
		String query = "insert into h_김용석_member\r\n" + 
				       "(id,name,age,reg_date)\r\n" + 
				       "values('"+dto.getId()+"','"+dto.getName()+"',"+dto.getAge()+",'"+dto.getReg_date()+"')";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	
	public ArrayList<Member_dto> getMemberList(String gubun, String search) {
		ArrayList<Member_dto> arr = new ArrayList<>();
		String query = " select id,name,age,to_char(reg_date,'yyyy-mm-dd') as reg_date\r\n" + 
				       " from H_김용석_MEMBER\r\n" + 
				       " where "+gubun+" like '%"+search+"%'\r\n" + 
				       " order by reg_date desc";
		
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String reg_date = rs.getString("reg_date");
				
				Member_dto dto = new Member_dto(id,name,age,reg_date);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류 : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return arr;
	}
	
	public Member_dto getMemberView(String id) {
		Member_dto dto = null;
		String query = " select id,name,age,to_char(reg_date,'yyyy-mm-dd') as reg_date\r\n" + 
				       " from H_김용석_MEMBER\r\n" + 
				       " where id = '"+id+"' "; 
				       
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {				
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String reg_date = rs.getString("reg_date");
				
				dto = new Member_dto(id,name,age,reg_date);
				
			}
			
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
	}
	public int getUpdate(Member_dto dto) {
		int result = 0;
		String query = " update h_김용석_member\r\n" + 
					   	   "    set name ='"+dto.getName()+"',\r\n" + 
					   	   "        age = "+dto.getAge()+",\r\n" + 
					   	   "        reg_date = '"+dto.getReg_date()+"'\r\n" + 
					   	   " where id = '"+dto.getId()+"'";
			
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	public int getDelete(String id) {
		int result = 0;
		String query = "delete from h_김용석_member\r\n" + 
				       "where id = '"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
}
