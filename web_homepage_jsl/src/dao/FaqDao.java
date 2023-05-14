package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.CommonUtil;
import common.DBConnection;
import dto.FaqDto;

public class FaqDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public int deleteDB(String no) {
		int k = 0;
		String sql = "delete from home_연석모_faq where no='"+no+"'";
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
	public int updateDB(FaqDto dto) {
		int k = 0;
		String title = dto.getTitle().replace("\'", "\''").replace("\"", "&quot;");
		String content = dto.getContent().replace("\'", "\''").replace("\"", "&quot;");
		String sql = "update home_연석모_faq set title='"+title+"', id='"+dto.getId()+"', reg_date=to_date('"+
						dto.getReg_date()+"','yyyy-MM-dd hh24:mi:ss'), content='"+content+"'"
						+ ", up_date=to_date('"+CommonUtil.getTodayTime()+"','yyyy-MM-dd hh24:mi:ss') where no='"+dto.getNo()+"'";
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
	
	public FaqDto updateViewDB(String no) {
		FaqDto dto = null;
		String sql = "select f.no, f.id, m.name, f.title, to_char(f.reg_date,'yyyy-mm-dd') as reg_date, f.content,"
				+ " to_char(f.up_date,'yyyy-MM-dd hh24:mi:ss') as up_date from home_연석모_faq f, home_연석모_member m"
				+ " where m.id=f.id and f.no='"+no+"' order by no desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String reg_date = rs.getString("reg_date");
				String content = rs.getString("content");
				String up_date = rs.getString("up_date");
				dto = new FaqDto(no,title,id,reg_date,content,name,up_date);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public ArrayList<FaqDto> searchDB(String gubun, String search){
		ArrayList<FaqDto> arr = new ArrayList<FaqDto>();
		String sql = "select f.no, f.id, m.name, f.title, to_char(f.reg_date,'yyyy-mm-dd') as reg_date,"
				+ " f.content, to_char(f.up_date,'yyyy-MM-dd hh24:mi:ss') as up_date from home_연석모_faq f, home_연석모_member m"
					+ " where m.id=f.id and "+gubun+" like '%"+search+"%' order by no desc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String reg_date = rs.getString("reg_date");
				String content = rs.getString("content");
				String up_date = rs.getString("up_date");
				FaqDto dto = new FaqDto(no,title,id,reg_date,content,name,up_date);
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
	
	public int insertDB(FaqDto dto) {
		int k = 0;
		String title = dto.getTitle().replace("\'", "\''").replace("\"", "&quot;");
		String content = dto.getContent().replace("\'", "\''").replace("\"", "&quot;");
		String sql = "insert into home_연석모_faq (no,title,id,reg_date,content) values('"+dto.getNo()+"','"+
					title+"','"+dto.getId()+"',to_date('"+dto.getReg_date()+"','yyyy-MM-dd hh24:mi:ss'),'"+
					content+"')";
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
	
	public String getNo() {
		String sql = "select nvl(max(no),'F000') as no from home_연석모_faq";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				sql = rs.getString("no");
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		int sq = Integer.parseInt(sql.substring(1));
		sq++;
		DecimalFormat df = new DecimalFormat("F000");
		sql = df.format(sq);
		return sql;
	}
	
	public ArrayList<FaqDto> selectDB(){
		ArrayList<FaqDto> arr = new ArrayList<FaqDto>();
		String sql = "select f.no, f.id, m.name, f.title, to_char(f.reg_date,'yyyy-mm-dd') as reg_date, f.content, "
					+ " to_char(f.up_date,'yyyy-MM-dd hh24:mi:ss') as up_date from home_연석모_faq f, home_연석모_member m"
					+ " where m.id=f.id order by no desc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String reg_date = rs.getString("reg_date");
				String content = rs.getString("content");
				String up_date = rs.getString("up_date");
				FaqDto dto = new FaqDto(no,title,id,reg_date,content,name,up_date);
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
