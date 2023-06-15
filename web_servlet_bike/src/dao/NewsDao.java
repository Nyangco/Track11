package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.CommonUtil;
import common.DBConnection;
import dto.NewsDto;

public class NewsDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public NewsDto noTitleDB(String no, String gubun) {
		NewsDto dto = null;
		String sql = "select no, title from bike_연석모_news where no";
		if(gubun.equals("pre")) sql+="<'"+no+"' order by no desc";
		else if(gubun.equals("pro")) sql+=">'"+no+"' order by no asc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String newNo = rs.getString("no");
				String title = rs.getString("title");
				dto = new NewsDto(newNo, title, "", "", "", "", "", "", "", "", 0);
			}
		}catch(SQLException e) {
			System.out.println("updateDB :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public int deleteDB(String no) {
		int k = 0;
		String sql = "delete bike_연석모_news where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("updateDB :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public int updateDB(NewsDto dto) {
		int k = 0;
		String sql = "update bike_연석모_news set title='"+dto.getTitle()+"', content='"+dto.getContent()+"', attach='"+dto.getAttach()
					+"', update_id='"+dto.getUpdate_id()+"', update_date=to_date('"+dto.getUpdate_date()+"','yyyy-mm-dd hh24:mi:ss') where no='"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("updateDB :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public void getHit(String no) {
		String sql = "update bike_연석모_news set hit = hit+1 where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			int k = ps.executeUpdate();
			if(k!=1) System.out.println("조회수 증가 오류");
		}catch(SQLException e) {
			System.out.println("getHit :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	public NewsDto viewDB(String no) {
		NewsDto dto = null;
		String sql = "select n.attach, n.title, n.hit, n.content, m.name as reg_name, to_char(n.reg_date,'yyyy-mm-dd') as reg_date, u.name as update_name,"
					+ " nvl(to_char(n.update_date,'yyyy-mm-dd hh24:mi:ss'),'해당 정보 없음') as update_date"
					+ " from bike_연석모_news n, bike_연석모_member m, bike_연석모_member u where n.reg_id=m.id and (n.update_id=u.id or u.id='000')"
					+ " and n.no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String attach = rs.getString("attach");
				String title = rs.getString("title");
				int hit = rs.getInt("hit");
				String content = rs.getString("content");
				String reg_name = rs.getString("reg_name");
				String reg_date = rs.getString("reg_date");
				String update_name = rs.getString("update_name");
				String update_date = rs.getString("update_date"); 
				dto = new NewsDto(no, title, content, attach, "", reg_date, reg_name, "", update_date, update_name, hit);
			}
		}catch(SQLException e) {
			System.out.println("viewDB :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public ArrayList<NewsDto> listDB(String select, String search, int start, int end){
		ArrayList<NewsDto> arr = new ArrayList<>();
		
		String subSql = "select n.no,n.title,n.content,n.attach,m.name,to_char(n.reg_date,'yyyy-mm-dd') as reg_date,hit from bike_연석모_news n,"
				+ " bike_연석모_member m where n.reg_id=m.id and "+select+" like '%"+search+"%' order by no desc";
		String sql = "select * from ( select rownum as rnum, sub.* from ("+subSql+") sub ) where rnum>="+start+" and rnum<="+end;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String rownum = rs.getString("rnum");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String attach = rs.getString("attach");
				String name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				int hit = rs.getInt("hit");
				NewsDto dto = new NewsDto(no, title, content, attach, rownum, reg_date, name, "", "", "", hit);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("listDB :"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	};
	
	public int totalCountDB(String select, String search) {
		int k = 0;
		String sql = "select count(*) as count from bike_연석모_news where "+select+" like '%"+search+"%'";
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
