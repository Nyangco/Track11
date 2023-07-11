package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.CommonUtil;
import common.DBConnection;
import dto.QnaDto;

public class QnaDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int countReplyDB(String no) {
		int k = 0;
		String sql = "select count(*) from bike_연석모_qna where reply='"+no+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count(*)");
			}
		}catch(SQLException e) {
			System.out.println("countReplyDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public int deleteDB(String no) {
		int k = 0;
		String sql1="";String sql2="";String sql3="";
		sql1 = "select step from bike_연석모_qna where no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			if(rs.next()) {
				int step = rs.getInt("step");
				sql2 = "update bike_연석모_qna set step=step-1 where step>"+step;
				ps = con.prepareStatement(sql2);
				ps.execute();
				sql3 = "delete bike_연석모_qna where no='"+no+"'";
				ps = con.prepareStatement(sql3);
				k = ps.executeUpdate();
			}
		}catch(SQLException e) {
			System.out.println("deleteDB:\n"+sql1+"\n"+sql2+"\n"+sql3);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}
	
	public QnaDto getReplyContent(String no) {
		QnaDto dto = null;
		String sql = "select content from bike_연석모_qna where no='"+no+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String content = rs.getString("content");
				dto = new QnaDto(no, "", "", "", content, "");
			}
		}catch(SQLException e) {
			System.out.println("totalCountDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public ArrayList<QnaDto> listDB(String select, String search, int start, int end){
		ArrayList<QnaDto> arr = new ArrayList<QnaDto>();
		String sql = "select q.step,q.reg_id, q.no,to_char(q.reg_date,'yyyy-mm-dd')as reg_date,q.content,q.reply,"
					+ "m.name, q.s_count from bike_연석모_qna q, bike_연석모_member m where "+select+" like '%"+search+"%' "
					+ "and m.id=q.reg_id order by step";
		sql = "select * from (select tbl.*, rownum as rnum from ("+sql+") tbl ) where rnum>="+start
				+" and rnum<="+end;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no = rs.getString("no");
				String reg_id = rs.getString("reg_id");
				String reg_name = rs.getString("name");
				String reg_date = rs.getString("reg_date");
				String content = rs.getString("content");
				String reply = rs.getString("reply");
				String s_count = rs.getString("s_count");
				QnaDto dto = new QnaDto(no, reg_id, reg_name, reg_date, content, reply, s_count);
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
		String sql = "select count(*) from bike_연석모_qna where "+select+" like '%"+search+"%'";
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
	
	public int insertDB(QnaDto dto) {
		int k = 0;
		String sql1 = ""; String sql2 = ""; String sql3=""; String reply=""; int s_count=0;
		if(dto.getReply().equals("Q000")) {
			sql1="select min(step) as step from bike_연석모_qna ";
			reply= dto.getNo();
		}else {
			sql1 = "select step,s_count from bike_연석모_qna where no='"+dto.getReply()+"'";
			reply= dto.getReply();
		}
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			if(rs.next()) {
				int step = rs.getInt("step");
				if(dto.getReply().equals("Q000")) {
					sql2 = "update bike_연석모_qna set step=step+1 where step>="+step;
				}else {
					sql2 = "update bike_연석모_qna set step=step+1 where step>"+step;
					s_count = rs.getInt("s_count");
					step++;
					s_count++;
				}
				ps = con.prepareStatement(sql2);
				ps.executeUpdate();
				sql3 = "insert into bike_연석모_qna (no,reg_id,reg_date,content,reply,step,s_count) values('"+dto.getNo()+"','"
						+dto.getReg_id()+"',to_date('"+CommonUtil.getToday()+"','yyyy-mm-dd'),'"+
						dto.getContent()+"','"+reply+"',"+step+","+s_count+")";
				ps = con.prepareStatement(sql3);
				k = ps.executeUpdate();
			}
		}catch(SQLException e) {
			System.out.println("insertDB:\n"+sql1+"\n"+sql2+"\n"+sql3);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public String getMaxNo() {
		String result = null;
		String sql = "select nvl(max(no),'Q000') as no from bike_연석모_qna";
		
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
		int iResult = Integer.parseInt((result.substring(1)));
		iResult++;
		DecimalFormat df = new DecimalFormat("Q000");
		result = df.format(iResult);
		return result;
	}
}
