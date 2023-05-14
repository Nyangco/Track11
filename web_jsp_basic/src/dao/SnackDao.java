package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.SnackDto;

public class SnackDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList<SnackDto> getCompanyList() {
		ArrayList<SnackDto> arr = new ArrayList<>();
		String query = "select m_code, m_name from commonsnack\r\n" + 
					   "order by m_name";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String m_name = rs.getString("m_name");
				String m_code = rs.getString("m_code");
				
				SnackDto dto = new SnackDto(m_code, m_name);
				arr.add(dto);
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return arr;
	}
	
	public int getSaveSnack(SnackDto dto) {
		int result = 0;
		String query = "insert into H_김용석_SNACK\r\n" + 
					   "(p_code,p_name,m_code,price)\r\n" + 
					   "values('"+dto.getP_code()+"','"+dto.getP_name()+"','"+dto.getM_code()+"',"+dto.getPrice()+")";
		
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
	
	public ArrayList<SnackDto> getSnackList(String gubun, String search){
		ArrayList<SnackDto> arr = new ArrayList<>();
		String query = "select h.p_code,h.p_name,c.m_name, to_char(h.price,'999,999')as price  \r\n" + 
				       "from H_김용석_SNACK h ,commonsnack c\r\n" + 
					   "where h.m_code = c.m_code\r\n" + 
					   "and "+gubun+" like '%"+search+"%'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String p_code = rs.getString("p_code");
				String p_name = rs.getString("p_name");
				String m_name = rs.getString("m_name");
				String strprice = rs.getString("price");
				
				SnackDto dto = new SnackDto(p_code,p_name,m_name,strprice);
				arr.add(dto);
				
			}
			
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	public SnackDto getSnackView(String p_code) {
		SnackDto dto = null;
		String query = "select h.p_code,h.p_name,c.m_code,c.m_name,to_char(h.price,'999,999')as price \r\n" + 
				"from H_김용석_SNACK h ,commonsnack c\r\n" + 
				"where h.m_code = c.m_code\r\n" + 
				"and h.p_code = '"+p_code+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String p_name = rs.getString("p_name");
				String m_code = rs.getString("m_code");
				String m_name = rs.getString("m_name");
				String strprice = rs.getString("price");
				
				dto = new SnackDto(p_code, p_name, m_code, m_name, strprice);
				
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return dto;
		
	}
	public int snackUpdate(SnackDto dto) {
		int result = 0;
		String query = "update h_김용석_snack\r\n" + 
				       "    set p_name='"+dto.getP_name()+"',\r\n" + 
				       "        price="+dto.getPrice()+",\r\n" + 
				       "        m_code='"+dto.getM_code()+"'\r\n" + 
				       "where p_code='"+dto.getP_code()+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("쿼리오류"+query);
			
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	public int snackDelete(String p_code) {
		int result = 0;
		String query = "delete from H_김용석_SNACK\r\n" + 
					   "where p_code='"+p_code+"'";
		
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
	public int checkPcode(String p_code) {
		int count = 0;
		String query = "select count(*) as count from H_김용석_SNACK\r\n" + 
					   "where p_code='"+p_code+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
		DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
}
