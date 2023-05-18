package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.CommonUtil;
import common.DBConnection;
import dto.MemberDto;

public class MemberDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int updateDB(MemberDto dto) {
		int k = 0;
		String sql = "update bike_연석모_member set name='"+dto.getName()+"', area='"+dto.getArea()+"', address='"+
					dto.getAddress()+"', mobile_1='"+dto.getMobile_1()+"', mobile_2='"+dto.getMobile_2()+"', mobile_3='"+
					dto.getMobile_3()+"', gender='"+dto.getGender()+"', hobby_travel='"+dto.getHobby_travel()+"', hobby_reading='"+
					dto.getHobby_reading()+"', hobby_sports='"+dto.getHobby_sports()+"', update_date=to_date('"+
					CommonUtil.getTodayTime()+"','yyyy-mm-dd hh24:mi:ss') where id = '"+dto.getId()+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("deleteDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public int deleteDB(String id) {
		int k = 0;
		String sql = "update bike_연석모_member set exit_date=to_date('"+CommonUtil.getToday()+"','yyyy-mm-dd') where id='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("deleteDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public MemberDto myinfoDB(String id) {
		MemberDto dto = null;
		String sql = "select id, slevel, name, password_len, area, address, mobile_1, mobile_2, mobile_3, gender, hobby_travel, hobby_reading, hobby_sports, "
					+ "to_char(reg_date,'yyyy-mm-dd') as reg_date, to_char(update_date,'yyyy-mm-dd') as update_date, "
					+ "to_char(last_login_date,'yyyy-mm-dd hh24:mi:ss') as last_login_date from bike_연석모_member where id = '"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String slevel = rs.getString("slevel");
				String name = rs.getString("name");
				int password_len = rs.getInt("password_len");
				String area = rs.getString("area");
				String address = rs.getString("address");
				String mobile_1 = rs.getString("mobile_1");
				String mobile_2 = rs.getString("mobile_2");
				String mobile_3 = rs.getString("mobile_3");
				String gender = rs.getString("gender");
				String hobby_travel = rs.getString("hobby_travel");
				String hobby_reading = rs.getString("hobby_reading");
				String hobby_sports = rs.getString("hobby_sports");
				String reg_date = rs.getString("reg_date");
				String update_date = rs.getString("update_date");
				String last_login_date = rs.getString("last_login_date");
				String password="";
				for(int k = 0; k<password_len; k++) {
					password+="*";
				}
				dto = new MemberDto(id,slevel,name,password,area,address,mobile_1,mobile_2,mobile_3,gender,hobby_travel,hobby_reading,hobby_sports,reg_date,update_date,last_login_date,"",0);
			}
		}catch(SQLException e) {
			System.out.println("myinfo : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public void recentLogin(String id) {
		String sql = "update bike_연석모_member set last_login_date=to_date('"+CommonUtil.getTodayTime()+"','yyyy-MM-dd hh24:mi:ss') where id='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			int k = ps.executeUpdate();
			if(k!=1) System.out.println("로그인 시간 갱신 오류");
		}catch(SQLException e) {
			System.out.println("idConfirmDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	public MemberDto idCheckDB(String id, String password) {
		MemberDto dto = null;
		String sql = "select slevel, name, exit_date from bike_연석모_member where id='"+id+"' and password='"+password+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String sLevel = rs.getString("slevel");
				String name = rs.getString("name");
				String exit_date = rs.getString("exit_date");
				dto = new MemberDto(sLevel,name,exit_date);
			}
		}catch(SQLException e) {
			System.out.println("idConfirmDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public int idCheckDB(String id) {
		int k = 0;
		String sql = "select count(*) as count from bike_연석모_member where id='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count");
			}
		}catch(SQLException e) {
			System.out.println("saveDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
		
	public int saveDB(MemberDto dto) {
		int k = 0;
		String sql = "insert into bike_연석모_member (id, name, password, area, address, mobile_1, mobile_2, mobile_3, "
					+ "gender, hobby_travel, hobby_reading, hobby_sports, reg_date, password_len) values ('"+dto.getId()+"', '"
					+dto.getName()+"', '"+dto.getPassword()+"', '"+dto.getArea()+"', '"+dto.getAddress()+"', '"+dto.getMobile_1()+"', '"
					+dto.getMobile_2()+"', '"+dto.getMobile_3()+"', '"+dto.getGender()+"', '"+dto.getHobby_travel()+"', '"
					+dto.getHobby_reading()+"', '"+dto.getHobby_sports()+"', to_date('"+dto.getReg_date()+"','yyyy-mm-dd'),"+dto.getPassword_len()+")";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("saveDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
}
