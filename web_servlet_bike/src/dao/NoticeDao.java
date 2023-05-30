package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.NoticeDto;

public class NoticeDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int updateDB(NoticeDto dto,String delete) {
		int k = 0;
		String sql = "update bike_연석모_notice set title='"+dto.getTitle()+"', content='"+dto.getContent()+"', update_date=to_date('"+
					dto.getUpdate_date()+"','yyyy-mm-dd hh24:mi:ss'), update_id='"+dto.getUpdate_id()+"'";
		if(dto.getAttach()!=null) sql = sql + ", attach='"+dto.getAttach()+"'";
		else if(delete.equals("y")) sql = sql + ", attach=''";
		sql = sql + " where no = '"+dto.getNo()+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("updateDB : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public int deleteDB(String no) {
		int k = 0;
		String sql = "delete from bike_연석모_notice where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("deleteDB : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}

	public NoticeDto getNo(String gubun, String no) {
		NoticeDto dto = null;
		String sql = "";
		if(gubun.equals("pre")) sql = "select Max(no) as no from bike_연석모_notice where no<'"+no+"'";
		else if(gubun.equals("pro")) sql = "select Min(no) as no from bike_연석모_notice where no>'"+no+"'";
		sql = "select no, title from bike_연석모_notice where no=("+sql+")";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String newNo = rs.getString("no");
				String title = rs.getString("title");
				if(title.length()>10) title=title.substring(0, 9)+"...";
				dto = new NoticeDto(newNo,title);
			}
		}catch(SQLException e) {
			System.out.println("getNo : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public NoticeDto viewDB(String no) {
		NoticeDto dto = null;
		String sql = "select n.title, n.hit, n.content, n.attach, m.name as reg_name, to_char(n.reg_date,'yyyy-mm-dd') as reg_date, "
					+ "u.name as update_name, to_char(n.update_date,'yyyy-mm-dd hh24:mi:ss') as update_date "
					+ "from bike_연석모_notice n, bike_연석모_member m, bike_연석모_member u "
					+ "where m.id = n.reg_id and no = '"+no+"' and ((u.id = n.update_id) or (u.id='000')) " ;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String attach = rs.getString("attach");
				String reg_name = rs.getString("reg_name");
				String reg_date = rs.getString("reg_date");
				String update_name = rs.getString("update_name");
				String update_date = rs.getString("update_date");
				if(update_date==null) update_date="수정 이력 없음";
				int hit = rs.getInt("hit");
				dto = new NoticeDto(no,"",title,content,attach,reg_date,update_date,update_name,reg_name,hit);
			}
		}catch(SQLException e) {
			System.out.println("viewDB : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public void getHit(String no) {
		String sql = "update bike_연석모_notice set hit = hit+1 where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			int k = ps.executeUpdate();
			if(k!=1) System.out.println("조회수 증가 오류"); 
		}catch(SQLException e) {
			System.out.println("getHit : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	public int totalCountDB(String select, String search) {
		int k = 0;
		String sql = "select count(*) as count from bike_연석모_notice where "+select+" like '%"+search+"%'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count");
			}
		}catch(SQLException e) {
			System.out.println("totalCountDB : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public ArrayList<NoticeDto> listDB(String select, String search, int start, int end){
		ArrayList<NoticeDto> arr = new ArrayList<NoticeDto>();
		
		String subSql = "select n.no, n.title, n.attach, m.name, to_char(n.reg_date,'yyyy-mm-dd') as reg_date, n.hit "
					+ "from bike_연석모_notice n, bike_연석모_member m where m.id=n.reg_id and "+select+" like '%"+search+"%' order by no desc";
		
		String sql = "select * from ( select rownum as rnum, sub.* from ("+subSql+") sub ) where rnum>="+start+" and rnum<="+end;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String attach = rs.getString("attach");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				int hit = rs.getInt("hit");
				NoticeDto dto = new NoticeDto(no,"",title,"",attach,reg_date,"","",reg_name,hit);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("listDB : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	public int insertDB(NoticeDto dto) {
		int k = 0;
		String sql = "";
		if(dto.getAttach()!=null) {
			sql = "insert into bike_연석모_notice (no,reg_id,title,content,attach,reg_date) values ('"+dto.getNo()+"','"+dto.getReg_id()+"','"+
					dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_date()+"')";
		}else {
			sql = "insert into bike_연석모_notice (no,reg_id,title,content,reg_date) values ('"+dto.getNo()+"','"+dto.getReg_id()+"','"+
					dto.getTitle()+"','"+dto.getContent()+"','"+dto.getReg_date()+"')";
		}
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
		DecimalFormat df = new DecimalFormat("N000");
		input = input.substring(1);
		int nInput = Integer.parseInt(input);
		nInput++;
		result = df.format(nInput);
		return result;
	}
}
