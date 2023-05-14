package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnection;
import dto.SnackDto;

public class SnackDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<SnackDto> makerDB(){
		ArrayList<SnackDto> arr = new ArrayList<>();
		String sql = "select m_code, m_name from commonsnack";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String m_code = rs.getString("m_code");
				String m_name = rs.getString("m_name");
				SnackDto dto = new SnackDto("","",m_code,m_name,0);
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
	
	public int duplicateDB(String p_code) {
		int k = 0;
		String sql = "select count(*) as count from h_연석모_snack where p_code='"+p_code+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count");
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public int deleteDB(String p_code) {
		int k = 0;
		String sql = "delete from h_연석모_snack where p_code='"+p_code+"'";
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
	
	public int updateDB(SnackDto dto) {
		int k = 0;
		String sql = "update h_연석모_snack set p_name='"+dto.getP_name()+"', m_code='"+
					dto.getM_code()+"', price="+dto.getPrice()+" where p_code='"+dto.getP_code()+"'";
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
	
	public SnackDto viewDB(String p_code) {
		SnackDto dto = null;
		String sql = "select h.p_name, c.m_name, h.m_code, h.price from h_연석모_snack h, commonsnack c where h.p_code='"+p_code+"'"
						+ " and h.m_code=c.m_code";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_name = rs.getString("p_name");
				String m_name = rs.getString("m_name");
				int price = rs.getInt("price");
				String m_code = rs.getString("m_code");
				dto = new SnackDto(p_code,p_name,m_code,m_name,price);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public int insertDB(SnackDto dto) {
		int k = 0;
		String sql = "insert into h_연석모_snack (p_code,p_name,m_code,price) values('"
					+dto.getP_code()+"','"+dto.getP_name()+"','"+dto.getM_code()+"',"+dto.getPrice()+")";
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
	
	public ArrayList<SnackDto> searchDB(String select, String search, String m_code){
		ArrayList<SnackDto> arr = new ArrayList<SnackDto>();
		String sql = "";
		if(m_code.equals("0")) {
			sql = "select h.p_code,h.p_name,c.m_name,h.price from h_연석모_snack h, " + 
				" commonsnack c where h.m_code = c.m_code and h."+select+" like '%"+search+"%' order by h.p_code desc";
		}else {
			sql = "select h.p_code,h.p_name,c.m_name,h.price from h_연석모_snack h, " + 
					" commonsnack c where h.m_code = c.m_code and h."+select+" like '%"+search+"%' "+
					" and h.m_code='"+m_code+"' order by h.p_code desc";
		}
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_code = rs.getString("p_code");
				String p_name = rs.getString("p_name");
				String m_name = rs.getString("m_name");
				int price = rs.getInt("price");
				
				SnackDto dto = new SnackDto(p_code,p_name,m_code,m_name,price);
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
	
	public ArrayList<SnackDto> listDB(){
		ArrayList<SnackDto> arr = new ArrayList<SnackDto>();
		String sql = "select h.p_code,h.p_name,c.m_name,h.price from h_연석모_snack h, "
				+ " commonsnack c where h.m_code = c.m_code order by h.p_code desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_code = rs.getString("p_code");
				String p_name = rs.getString("p_name");
				String m_name = rs.getString("m_name");
				int price = rs.getInt("price");
				SnackDto dto = new SnackDto(p_code,p_name,"",m_name,price);
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

