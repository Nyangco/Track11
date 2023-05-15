package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnection;
import dto.MemberDto;

public class MemberDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
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
