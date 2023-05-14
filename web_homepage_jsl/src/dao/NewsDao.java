package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.NewsDto;

public class NewsDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	//삭제
	public int deleteDB(String no) {
		int k = 0;
		String sql = "delete home_연석모_news where no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	// 업데이트
	public int updateDB(NewsDto dto) {
		int k = 0;
		String title = dto.getTitle().replace("\'", "\''").replace("\"", "&quot;");
		String content = dto.getContent().replace("\'", "\''").replace("\"", "&quot;");
		String sql = "update home_연석모_news set title='"+title+"', content='"+content+"', reg_id='"
				+dto.getReg_id()+"', update_date=to_date('"+dto.getUpdate_date()+"','yyyy-MM-dd hh-mi-ss') where no='"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	// 제목 따오기
	public NewsDto titleDB(String no, String gubun) {
		NewsDto dto = null;
		String sql = "";
		if(gubun.equals("pre")) sql = "select no,title from home_연석모_news where no<'"+no+"' order by no desc";
		else if(gubun.equals("pro")) sql = "select no,title from home_연석모_news where no>'"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no");
				sql = rs.getString("title");
				if(sql.length()>10) sql = sql.substring(0,9)+"...";
				dto = new NewsDto(no,sql);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	// 조회수 올리기
	public void addHit(String no) {
		String sql = "update home_연석모_news set hit=hit+1 where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			int k = ps.executeUpdate();
			if(k!=1) System.out.println("hit 증가 오류");
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	// 상세 조회
	public NewsDto viewDB(String no) {
		NewsDto dto = null;
		String sql = "select n.title,n.content,m.name,to_char(n.reg_date,'yyyy-MM-dd hh:mi:ss') as reg_date,nvl(to_char(n.update_date,'yyyy-MM-dd hh:mi:ss'),'0000-00-00') as update_date,n.hit "
				+ " from home_연석모_member m, home_연석모_news n where m.id = n.reg_id and n.no = '"+no+"' order by n.no desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				String update_date = rs.getString("update_date");
				if(update_date.equals("0000-00-00")) update_date = "업데이트 정보 없음";
				int hit = rs.getInt("hit");
				dto = new NewsDto(title,content,reg_name,reg_date,update_date,hit);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	// 특정 조건 조회
	public ArrayList<NewsDto> searchDB(String select, String search){
		ArrayList<NewsDto> arr = new ArrayList<NewsDto>();
		String sql = "select n.no,n.title,m.name,to_char(n.reg_date,'yyyy-MM-dd') as reg_date,n.hit from home_연석모_member m, home_연석모_news n where m.id = n.reg_id"
				+ " and "+select+" like '%"+search+"%' order by n.no desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				int hit = rs.getInt("hit");
				NewsDto dto = new NewsDto(no,title,reg_name,reg_date,hit);
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
	
	//전체 리스트 확인
	public ArrayList<NewsDto> listDB(){
		ArrayList<NewsDto> arr = new ArrayList<NewsDto>();
		String sql = "select n.no,n.title,m.name,to_char(n.reg_date,'yyyy-MM-dd') as reg_date,n.hit from home_연석모_member m, home_연석모_news n where m.id = n.reg_id"
				+ " order by n.no desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				int hit = rs.getInt("hit");
				NewsDto dto = new NewsDto(no,title,reg_name,reg_date,hit);
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
	
	//news 집어넣기
	public int insertDB(NewsDto dto) {
		int k = 0;
		String title = dto.getTitle().replace("\'", "\''").replace("\"", "&quot;");
		String content = dto.getContent().replace("\'", "\''").replace("\"", "&quot;");
		String sql = "insert into home_연석모_news (no, title, content, reg_id, reg_date) values('"+
					dto.getNo()+"','"+title+"','"+content+"','"+dto.getReg_id()+"',to_date('"+dto.getReg_date()+"','yyyy-MM-dd hh:mi:ss'))";
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

	//No중 제일 큰 값 구하기
	public String getMaxNo() {
		String result=null;
		String sql = "select nvl(max(no),'N000') as no from home_연석모_news";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("no");
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		result = result.substring(1);
		int r = Integer.parseInt(result);
		r++;
		DecimalFormat df = new DecimalFormat("N000");
		result = df.format(r);
		return result;
	}
}
