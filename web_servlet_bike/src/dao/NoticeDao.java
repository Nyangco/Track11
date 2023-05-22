package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import common.DBConnection;
import dto.NoticeDto;

public class NoticeDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int insertDB(NoticeDto dto) {
		int k = 0;
		String sql = "insert into bike_연석모_notice (no,reg_id,title,content,attach,reg_date) values ('"+dto.getNo()+"','"+dto.getReg_id()+"','"+
					dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_date()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("insertDB : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public String getMaxNo() {
		String result = "";
		String sql = "select Max(no) from bike_연석모_notice";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String no = rs.getString("Max(no)");
				if(no==null) no="N000";
				result = nextNo(no);
			}
		}catch(SQLException e) {
			System.out.println("getMaxNo : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	private String nextNo(String input) {
		String result = null;
		DecimalFormat df = new DecimalFormat("N###");
		input = input.substring(1);
		int nInput = Integer.parseInt(input);
		nInput++;
		result = df.format(nInput);
		return result;
	}
}
