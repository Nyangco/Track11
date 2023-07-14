package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.FreeboardDto;

public class FreeboardDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//dao.clearDown(no);
	public void clearDown(String no) {
		String sql = "update bike_연석모_product set download_hit=0 where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			int k = ps.executeUpdate();
			if(k!=1) System.out.println("다운 횟수 초기화 오류");
		}catch(SQLException e) {
			System.out.println("clearDown"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	public int deleteDB(String no) {
		int k = 0;
		String sql = "delete bike_연석모_freeboard where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("deleteDB"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public void getDownloadHit(String no) {
		String sql = "update bike_연석모_freeboard set download_hit=download_hit+1 where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			int k = ps.executeUpdate();
			if(k!=1) System.out.println("다운로드 증가 오류");
		}catch(SQLException e) {
			System.out.println("getDownloadHit"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	public void getHit(String no) {
		String sql = "update bike_연석모_freeboard set hit=hit+1 where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			int k = ps.executeUpdate();
			if(k!=1) System.out.println("조회수 증가 오류");
		}catch(SQLException e) {
			System.out.println("getHit"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	public int updateDB(FreeboardDto dto) {
		int k = 0;
		String attach = dto.getAttach();
		if(attach==null) attach="";
		String sql = "update bike_연석모_freeboard set title='"+dto.getTitle()+"', content='"+dto.getContent()+"', "
					+ "attach='"+attach+"', update_date=to_date('"+dto.getUpdate_date()+"','yyyy-mm-dd') "
					+ "where no = '"+dto.getNo()+"'";
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
	
	public FreeboardDto prePro(String no, String gubun) {
		FreeboardDto dto = null;
		String sql = "select no, title from bike_연석모_freeboard where no";
		if(gubun.equals("pre")) sql += "<'"+no+"' order by no desc";
		if(gubun.equals("pro")) sql += ">'"+no+"' order by no asc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String newNo = rs.getString("no");
				String title = rs.getString("title");
				dto = new FreeboardDto(newNo, title, null, null, null, null, null, null, 0, 0, 0);
			}
		}catch(SQLException e) {
			System.out.println("prePro:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}

	public FreeboardDto viewDB(String no) {
		FreeboardDto dto = null;
		String sql = "select f.title,f.hit,f.content,f.attach,f.reg_id,m.name,to_char(f.reg_date,'yyyy-mm-dd') as reg_date, "
				+ "to_char(f.update_date,'yyyy-mm-dd') as update_date, f.download_hit from bike_연석모_freeboard f, bike_연석모_member m where no='"+no+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String attach = rs.getString("attach");
				String reg_id = rs.getString("reg_id");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				String update_date = rs.getString("update_date");
				int hit = rs.getInt("hit");
				int download_hit = rs.getInt("download_hit");
				dto = new FreeboardDto(no, title, content, attach, reg_id, reg_name, reg_date, update_date, hit, download_hit, 0);
			}
		}catch(SQLException e) {
			System.out.println("viewDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public int insertDB(FreeboardDto dto) {
		int k = 0;
		String attach=dto.getAttach();
		if(dto.getAttach()==null) attach="";
		String sql = "insert into bike_연석모_freeboard (no,title,content,attach,reg_id,reg_date) values ('"+
					dto.getNo()+ "','"+dto.getTitle()+"','"+dto.getContent()+"','"+attach+"','"+
					dto.getReg_id()+"',to_date('"+dto.getReg_date()+"','yyyy-mm-dd'))";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("insertDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public String getMaxNo() {
		String result = null;
		String sql = "select nvl(max(no),'F000') as no from bike_연석모_freeboard";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("no");
			}
		}catch(SQLException e) {
			System.out.println("getMaxNo:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		DecimalFormat df = new DecimalFormat("F000");
		int iResult = Integer.parseInt(result.substring(1));
		iResult++;
		result = df.format(iResult);
		return result;
	}

	public ArrayList<FreeboardDto> listDB(String select, String search, int start, int end){
		ArrayList<FreeboardDto> arr = new ArrayList<FreeboardDto>();
		String sql = "select f.no, f.title, f.attach, m.name as reg_name, to_char(m.reg_date,'yyyy-mm-dd') as reg_date, "
					+ "hit, c_count from bike_연석모_freeboard f, bike_연석모_member m where f.reg_id=m.id "
					+ "and "+select+" like '%"+search+"%' order by reg_date desc";
		sql = "select * from (select tbl.*, rownum as rnum from ("+sql+") tbl) where rnum>="+start+" and rnum<="+end;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String attach = rs.getString("attach");
				String reg_name = rs.getString("reg_name");
				String reg_date = rs.getString("reg_date");
				int hit = rs.getInt("hit");
				int c_count = rs.getInt("c_count");
				FreeboardDto dto = new FreeboardDto(no, title, null, attach, null, reg_name, reg_date, null, hit, 0, c_count);
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
		String sql = "select count(*) from bike_연석모_freeboard where "+select+" like '%"+search+"%'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count(*)");
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
