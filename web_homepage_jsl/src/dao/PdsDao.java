package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.PdsDto;

public class PdsDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public int getTotalCount(String select, String search) {
		int k = 0;
		String sql = "select count(*) as count from home_연석모_pds n where "+select+" like '%"+search+"%'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count");
			}
		}catch(SQLException e) {
			System.out.println("SQL : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public ArrayList<PdsDto> searchDB(String select, String search, int start, int end){
		ArrayList<PdsDto> arr = new ArrayList<PdsDto>();
		String sql = "select * from (select rownum as rnum , tbl.* from (select n.no, n.title, n.attach, n.hit, m.name, to_char(n.reg_date,'YYYY-MM-DD') as reg_date "
				+ "from home_연석모_member m, home_연석모_pds n "
				+ "where m.id=n.reg_id and "+select+" like '%"+search+"%' order by n.no desc ) tbl ) where rnum>="+start+" and rnum<="+end;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String attach = rs.getString("attach");
				if(attach==null) attach = "";
				int hit = rs.getInt("hit");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				PdsDto dto = new PdsDto(no,title,"",attach,"",reg_date,reg_name,hit);
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
	
	public int countDB() {
		int k = 0;
		String sql = "select count(*) as count from home_연석모_pds";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count");
			}
		}catch(SQLException e) {
			System.out.println("SQL : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}
	
	public int deleteDB(String no) {
		int k = 0;
		String sql = "delete from home_연석모_pds where no='"+no+"'";
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
	
	public int updateDB(String no, String title, String content, String attach, String check) {
		int k = 0;
		String sql = "";
		if(attach!=null) {
			sql = "update home_연석모_pds set title='"+title+"', content='"+content+"', attach='"+attach+"' where no='"+no+"'";
		}else if(attach==null && check==null) {
			sql = "update home_연석모_pds set title='"+title+"', content='"+content+"' where no='"+no+"'";
		}else if(attach==null && check!=null) {
			sql = "update home_연석모_pds set title='"+title+"', content='"+content+"', attach='' where no='"+no+"'";
		}
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQL"+sql);
			e.printStackTrace();
		}
		return k;
	}
	
	public void addHit(String no) {
		String sql="update home_연석모_pds set hit=hit+1 where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			int result = ps.executeUpdate();
			if(result==0) System.out.println("공지사항 조회수 증가 오류");
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	public PdsDto titleDB(String no,String gubun){
		PdsDto dto = null;
		String sql = "";
		if(gubun.equals("pro")) sql = "select a.no, b.title from (select min(no) as no from home_연석모_pds where no>'"+no+"') a, home_연석모_pds b where a.no=b.no";
		else if(gubun.equals("pre")) sql = "select a.no, b.title from (select max(no) as no from home_연석모_pds where no<'"+no+"') a, home_연석모_pds b where a.no=b.no";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				no = rs.getString("no");
				String title = rs.getString("title");
				if(title.length()>10) title = title.substring(0,9)+"...";
				dto = new PdsDto(no, title);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public PdsDto viewDB(String no){
		PdsDto dto = null;
		String sql = "select n.title, n.content, n.attach, n.hit, m.name, to_char(n.reg_date,'YYYY-MM-DD hh:mi:ss') as reg_date "
				+ "from home_연석모_member m, home_연석모_pds n "
				+ "where m.id=n.reg_id and n.no='"+no+"' order by n.no desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String attach = rs.getString("attach");
				int hit = rs.getInt("hit");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				dto = new PdsDto(title,content,attach,reg_date,reg_name,hit);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public int pdsSave(PdsDto dto) {
		int k = 0;
		String attach = "";
		String title = dto.getTitle().replace("\'", "\''").replace("\"", "&quot;");
		String content = dto.getContent().replace("\'", "\''").replace("\"", "&quot;");
		if(dto.getAttach()==null) attach = "";
		else attach = dto.getAttach();
		String sql = "insert into home_연석모_pds (no,title,content,attach,reg_id,reg_date) "
				+ "values('"+dto.getNo()+"','"+title+"','"+content+"','"
				+attach+"','"+dto.getReg_id()+"',to_date('"+dto.getReg_date()+"','yyyy-MM-dd hh24:mi:ss'))";
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
	
	public ArrayList<PdsDto> searchDB(String select, String search){
		ArrayList<PdsDto> arr = new ArrayList<PdsDto>();
		String sql = "select n.no, n.title, n.attach, n.hit, m.name, to_char(n.reg_date,'YYYY-MM-DD') as reg_date "
				+ "from home_연석모_member m, home_연석모_pds n "
				+ "where m.id=n.reg_id and "+select+" like '%"+search+"%' order by n.no desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String attach = rs.getString("attach");
				int hit = rs.getInt("hit");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				PdsDto dto = new PdsDto(no,title,"",attach,"",reg_date,reg_name,hit);
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
	
	public ArrayList<PdsDto> listDB(){
		ArrayList<PdsDto> arr = new ArrayList<PdsDto>();
		String sql = "select n.no, n.title, n.hit, m.name, to_char(n.reg_date,'YYYY-MM-DD') as reg_date "
				+ "from home_연석모_member m, home_연석모_pds n "
				+ "where m.id=n.reg_id order by n.no desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				int hit = rs.getInt("hit");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				PdsDto dto = new PdsDto(no,title,reg_date,reg_name,hit);
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
	
	public String getMaxNo() {
		String no="";
		String sql="select nvl(max(no),'P000') as no from home_연석모_pds";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no");
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		no					= no.substring(1);
		int intNo			= Integer.parseInt(no)+1;
		DecimalFormat df	= new DecimalFormat("P000");
		no					= df.format(intNo);
		return no;
	}
	
}
