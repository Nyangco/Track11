package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.QnaDto;

public class QnaDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public int deleteDB(String no) {
		int k = 0;
		String sql = "delete from home_연석모_qna where no='"+no+"'";
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
	
	public QnaDto titleDB(String no, String gubun) {
		QnaDto dto = null;
		String sql="";
		if(gubun.equals("pre")) sql="select no, title from home_연석모_qna where no<'"+no+"' order by no desc";
		else if(gubun.equals("pro")) sql="select no, title from home_연석모_qna where no>'"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				no = rs.getString("no");
				String title = rs.getString("title");
				dto = new QnaDto(no,title);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public int updateDB(QnaDto dto) {
		int k = 0;
		String title = dto.getTitle().replace("\'", "\''").replace("\"", "&quot;");
		String content = dto.getContent().replace("\'", "\''").replace("\"", "&quot;");
		String sql = "update home_연석모_qna set title='"+title+"', content='"+content+"', attach='"+
					dto.getAttach()+"', up_date=to_date('"+dto.getUp_date()+"','yyyy-mm-dd hh24:mi:ss') where no='"+dto.getNo()+"'";
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
	
	public QnaDto updateListDB(String no) {
		QnaDto dto = null;
		String sql = "select q.title, q.content, to_char(q.reg_date,'yyyy-mm-dd hh24:mi:ss') as reg_date, m.name, q.attach, "
				+ " to_char(q.up_date,'yyyy-mm-dd hh24:mi:ss') as up_date from home_연석모_qna q,"
				+ " home_연석모_member m where q.id = m.id and q.no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String reg_date = rs.getString("reg_date");
				String name = rs.getString("name");
				String attach = rs.getString("attach");
				String up_date = rs.getString("up_date");
				dto = new QnaDto("","","",title,content,attach,reg_date,name,up_date,0);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public void addHit(String no) {
		String sql = "update home_연석모_qna set hit = hit+1 where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			int k = ps.executeUpdate();
			if(k!=1) System.out.println(sql);
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	public int replyDB(String no, String content) {
		int k = 0;
		content = content.replace("\'", "\''").replace("\"", "&quot;");
		String sql = "update home_연석모_qna set reply='"+content+"' where no = '"+no+"'";
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
	
	public QnaDto viewDB(String no) {
		QnaDto dto = null;
		String sql = "select q.reply, q.id, q.title, q.content, to_char(q.reg_date,'yyyy-mm-dd hh24:mi:ss') as reg_date, m.name, to_char(q.up_date,'yyyy-mm-dd hh24:mi:ss') as up_date, q.attach, q.hit from home_연석모_qna q,"
				+ " home_연석모_member m where q.id = m.id and q.no = '"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String reply = rs.getString("reply");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String reg_date = rs.getString("reg_date");
				String name = rs.getString("name");
				String up_date = rs.getString("up_date");
				int hit = rs.getInt("hit");
				dto = new QnaDto(reply,id,title,content,reg_date,name,up_date,hit);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public ArrayList<QnaDto> searchDB(String gubun, String search){
		ArrayList<QnaDto> arr = new ArrayList<QnaDto>();
		String sql = "select q.no, q.reply, m.name, q.title, to_char(q.reg_date,'yyyy-MM-dd') as reg_date, q.hit from home_연석모_qna q, home_연석모_member m"
				+ " where q.id = m.id and q."+gubun+" like '%"+search+"%' order by q.no desc ";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String reply = rs.getString("reply");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String reg_date = rs.getString("reg_date");
				int hit = rs.getInt("hit");
				QnaDto dto = new QnaDto(no,reply,name,title,reg_date,hit);
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
	
	public ArrayList<QnaDto> listDB(){
		ArrayList<QnaDto> arr = new ArrayList<QnaDto>();
		String sql = "select q.no, q.reply, m.name, q.title, to_char(q.reg_date,'yyyy-MM-dd') as reg_date, q.hit from home_연석모_qna q, home_연석모_member m"
				+ " where q.id = m.id order by q.no desc ";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String reply = rs.getString("reply");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String reg_date = rs.getString("reg_date");
				int hit = rs.getInt("hit");
				QnaDto dto = new QnaDto(no,reply,name,title,reg_date,hit);
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
		String result = null;
		String sql = "select nvl(max(no),'Q000') as no from home_연석모_qna";
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
		DecimalFormat df = new DecimalFormat("Q000");
		result = df.format(r);
		return result;
	}
	
	public int insertDB(QnaDto dto) {
		int k = 0;
		String title = dto.getTitle().replace("\'", "\''").replace("\"", "&quot;");
		String content = dto.getContent().replace("\'", "\''").replace("\"", "&quot;");
		String sql = "insert into home_연석모_qna (no,id,title,content,attach,reg_date) values ('"+
				dto.getNo()+ "','"+dto.getId()+"','"+title+"','"+
				content+"','"+dto.getAttach()+"',to_date('"+dto.getReg_date()+"','yyyy-MM-dd hh24:mi:ss'))";
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
}
