package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import common.CommonUtil;
import common.DBConnection;
import dto.NewsDto;

public class NewsDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int totalCountDB(String select, String search) {
		int k = 0;
		String sql = "select count(*) as count from bike_연석모_news where select='"+select+"' and search like '%"+search+"%'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) k = rs.getInt("count");
		}catch(SQLException e) {
			System.out.println("totalCountDB :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public String getMaxNo() {
		String result = null;
		String sql = "select nvl(Max(no),'N000') as no from bike_연석모_news";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) result = rs.getString("no");
		}catch(SQLException e) {
			System.out.println("getMaxNo :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		DecimalFormat df = new DecimalFormat("N000");
		int iResult = Integer.parseInt(result.substring(1));
		iResult++;
		result = df.format(iResult);
		
		return result;
	}
	
	public int insertDB(NewsDto dto) {
		int k = 0;
		String sql = "insert into bike_연석모_news (no,title,content,attach,reg_id,reg_date) values ('"
					+dto.getNo()+ "','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_id()+"','"+dto.getReg_date()+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("insertDB :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
}
