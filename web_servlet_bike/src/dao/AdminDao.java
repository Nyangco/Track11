package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.CommonUtil;
import common.DBConnection;
import dto.AdminDto;

public class AdminDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int updateDB(String id, String sLevel) {
		int k = 0;
		String sql = "update bike_연석모_member set sLevel='"+sLevel+"' where id='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("updateDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}

	public int deleteDB(String id) {
		int k = 0;
		String sql = "update bike_연석모_member set exit_date = to_date('"+CommonUtil.getToday()+"','yyyy-mm-dd') where id='"+id+"'";
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
	
	public AdminDto ViewDB(String id) {
		AdminDto dto = null;
		String sql = "select sLevel, name, area, address, mobile_1, mobile_2, mobile_3, gender, hobby_travel, hobby_reading, "
					+ "hobby_sports, to_char(reg_date,'yyyy-mm-dd') as reg_date, to_char(update_date,'yyyy-mm-dd hh24:mi:ss') as update_date, "
					+ "to_char(last_login_date,'yyyy-mm-dd hh24:mi:ss') as last_login_date, to_char(exit_date,'yyyy-mm-dd') as exit_date, "
					+ "email, password_len from bike_연석모_member where id = '"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String sLevel = rs.getString("sLevel");
				String name = rs.getString("name");
				int pwLen = rs.getInt("password_len");
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
				String exit_date = rs.getString("exit_date");
				String email = rs.getString("email");
				dto = new AdminDto(id, sLevel, name, area, address, mobile_1, mobile_2, mobile_3, gender, hobby_travel, hobby_reading, hobby_sports, reg_date, update_date, last_login_date, exit_date, email, pwLen);
			}
		}catch(SQLException e) {
			System.out.println("viewDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
		
	public ArrayList<AdminDto> listDB(String select, String search, int start, int end) {
		ArrayList<AdminDto> arr = new ArrayList<AdminDto>();
		String subSql = "select id, slevel, name, email, area, mobile_1, mobile_2, mobile_3, to_char(reg_date,'yyyy-mm-dd') as reg_date, "
					+ "to_char(last_login_date,'yyyy-mm-dd hh24:mi:ss') as last_login_date, to_char(exit_date,'mm-dd') as exit_date "
					+ "from bike_연석모_member where "+select+" like '%"+search+"%'";
		String sql = "select * from (select rownum as rnum, tbl.* from ("+subSql+") tbl) where rnum>="+start+" and rnum<="+end+" order by reg_date desc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String sLevel = rs.getString("sLevel");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String area = rs.getString("area");
				String mobile_1 = rs.getString("mobile_1");
				String mobile_2 = rs.getString("mobile_2");
				String mobile_3 = rs.getString("mobile_3");
				String reg_date = rs.getString("reg_date");
				String last_login_date = rs.getString("last_login_date");
				String exit_date = rs.getString("exit_date");
				AdminDto dto = new AdminDto(id, sLevel, name, area, "", mobile_1, mobile_2, mobile_3, "", "", "", "", reg_date, "", last_login_date, exit_date, email, 0);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("listDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	public int totalCountDB(String select, String search) {
		int k = 0;
		String sql = "select count(*) as count from bike_연석모_member where "+select+" like '%"+search+"%'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count");
			}
		}catch(SQLException e) {
			System.out.println("totalCountDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
}
