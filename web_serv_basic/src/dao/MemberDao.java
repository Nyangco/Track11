package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnection;
import dto.MemberDto;

public class MemberDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int deleteDB(String id) {
		int k = 0;
		String sql = "delete from h_연석모_member where id='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public int updateDB(String id, String name, String age, String reg_date) {
		int k = 0;
		String sql = "update h_연석모_member set name='"+name+"', age='"+age+"', reg_date=to_date('"
					+reg_date+"','yyyy-mm-dd') where id='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public MemberDto viewDB(String id) {
		MemberDto dto = null;
		String sql = "select id, name, age, to_char(reg_date,'yyyy-mm-dd') as reg_date"
				+ " from h_연석모_member where id = '"+id+"' order by reg_date desc ";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String reg_date = rs.getString("reg_date");
				dto = new MemberDto(id,name,reg_date,age);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public int insertDB(MemberDto dto) {
		int k = 0;
		String sql = "insert into h_연석모_member (id,name,age,reg_date) values('"+dto.getId()+"','"+dto.getName()+"',"+
					dto.getAge()+",to_date('"+dto.getReg_date()+"','yyyy-mm-dd'))";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public ArrayList<MemberDto> searchDB(String select, String search){
		ArrayList<MemberDto> arr = new ArrayList<MemberDto>();
		String sql = "select id, name, age, to_char(reg_date,'yyyy-mm-dd') as reg_date"
				+ " from h_연석모_member where "+select+" like '%"+search+"%' order by reg_date desc ";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String reg_date = rs.getString("reg_date");
				MemberDto dto = new MemberDto(id,name,reg_date,age);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	} 
	
	public int countDB() {
		int k = 0;
		String sql = "select count(*) from h_연석모_member";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count(*)");
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public ArrayList<MemberDto> listDB(){
		ArrayList<MemberDto> arr = new ArrayList<MemberDto>();
		String sql = "select id, name, age, to_char(reg_date,'yyyy-mm-dd') as reg_date"
				+ " from h_연석모_member order by reg_date desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String reg_date = rs.getString("reg_date");
				MemberDto dto = new MemberDto(id,name,reg_date,age);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
}
