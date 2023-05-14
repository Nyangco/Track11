package dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import common.CommonUtil;
import common.DBConnection;
import dto.MemberDto;

public class MemberDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public int deleteDB(String id) {
		int k = 0;
		String sql = "update home_연석모_member set quit=1 where id='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQL : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public MemberDto viewDB(String id) {
		MemberDto dto = null;
		String sql = "select id, name,password,job,tell_1,tell_2,tell_3,mobile,email,to_char(reg_date,'yyyy-MM-dd') as reg_date,"
				+ " to_char(login_date,'yyyy-MM-dd hh24:mi:ss') as login_date, pwlength, quit from home_연석모_member "
				+ " where id='"+id+"' order by login_date desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				String job = rs.getString("job");
				String tell_1 = rs.getString("tell_1");
				String tell_2 = rs.getString("tell_2");
				String tell_3 = rs.getString("tell_3");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String reg_date = rs.getString("reg_date");
				String login_date = rs.getString("login_date");
				int pwlength = rs.getInt("pwlength");
				int quit = rs.getInt("quit");
				if(quit==1) login_date="탈퇴한 계정입니다.";
				dto = new MemberDto(id,name,password,job,tell_1,tell_2,tell_3,mobile,email,reg_date,login_date,pwlength);
			}
		}catch(SQLException e) {
			System.out.println("SQL: "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public void updateLogin(String id) {
		String sql = "update home_연석모_member set login_date = to_date('"+CommonUtil.getTodayTime()+"','yyyy-MM-dd hh24:mi:ss') where id='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			int k = ps.executeUpdate();
			if(k!=1) System.out.println("로그인 시간 갱신 오류");
		}catch(SQLException e) {
			System.out.println("SQL : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}
	
	public ArrayList<MemberDto> searchDB(String gubun, String search){
		ArrayList<MemberDto> arr = new ArrayList<MemberDto>();
		String sql = "select id, name,password,job,tell_1,tell_2,tell_3,mobile,email,to_char(reg_date,'yyyy-MM-dd') as reg_date,"
				+ " to_char(login_date,'yyyy-MM-dd hh24:mi:ss') as login_date, quit from home_연석모_member "
				+ " where "+gubun+" like '%"+search+"%' order by login_date desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String job = rs.getString("job");
				String tell_1 = rs.getString("tell_1");
				String tell_2 = rs.getString("tell_2");
				String tell_3 = rs.getString("tell_3");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String reg_date = rs.getString("reg_date");
				String login_date = rs.getString("login_date");
				int quit = rs.getInt("quit");
				MemberDto dto = new MemberDto(id,name,password,job,tell_1,tell_2,tell_3,mobile,email,reg_date,login_date,quit);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("SQL: "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	public ArrayList<MemberDto> selectDB(){
		ArrayList<MemberDto> arr = new ArrayList<MemberDto>();
		String sql = "select id, name,password,job,tell_1,tell_2,tell_3,mobile,email,to_char(reg_date,'yyyy-MM-dd') as reg_date,"
				+ " to_char(login_date,'yyyy-MM-dd hh24:mi:ss') as login_date, quit from home_연석모_member order by login_date desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String job = rs.getString("job");
				String tell_1 = rs.getString("tell_1");
				String tell_2 = rs.getString("tell_2");
				String tell_3 = rs.getString("tell_3");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String reg_date = rs.getString("reg_date");
				String login_date = rs.getString("login_date");
				int quit = rs.getInt("quit");
				MemberDto dto = new MemberDto(id,name,password,job,tell_1,tell_2,tell_3,mobile,email,reg_date,login_date,quit);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("SQL: "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	public int checkId(String id) {
		int k = 0;
		String sql = "select count(*) as count from home_연석모_member where id='"+id+"'";
		
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
	
	public int updateDB(MemberDto dto) {
		int k = 0;
		String sql = "update home_연석모_member set name='"+dto.getName()+"', job='"+dto.getJob()+"', tell_1='"+dto.getTell_1()+"', "
					+ "tell_2='"+dto.getTell_2()+"', tell_3='"+dto.getTell_3()+"', mobile='"+dto.getMobile()+"', email='"+dto.getEmail()+"' "
					+ "where id='"+dto.getId()+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQL : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public String getPW(String id) {
		String pw = "";
		String sql = "select password from home_연석모_member where id='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				pw = rs.getString("password");
			}
		}catch(SQLException e) {
			System.out.println("SQL: "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return pw;
	}
	
	public int changePW(String id, String pw) {
		int k = 0;
		String sql = "update home_연석모_member set password='"+pw+"' where id='"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQL : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public MemberDto getMemberDB(String id) {
		MemberDto dto = null;
		String sql = "select name,job,tell_1,tell_2,tell_3,mobile,email,to_char(reg_date,'yyyy-MM-dd') as reg_date from home_연석모_member where id = '"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String job = rs.getString("job");
				String tell_1 = rs.getString("tell_1");
				String tell_2 = rs.getString("tell_2");
				String tell_3 = rs.getString("tell_3");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String reg_date = rs.getString("reg_date");
				dto = new MemberDto(name,job,tell_1,tell_2,tell_3,mobile,email,reg_date);
				
			}
		}catch(SQLException e) {
			System.out.println("SQL : "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return dto;
	}
	
	public MemberDto checkLogin(String id, String password) {
		MemberDto dto = null;
		String sql = "select name,quit from home_연석모_member where id='"+id+"' and password='"+password+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String quit = rs.getString("quit");
				dto = new MemberDto(name,quit);
			}
		}catch(SQLException e) {
			System.out.println("SQL:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return dto;
	}
	
	public int insertDB(MemberDto dto) {
		int k = 0;
		String sql = "insert into home_연석모_member (id,name,password,job,tell_1,tell_2,tell_3,mobile,email,reg_date,pwlength) values('"
				+dto.getId()+"', '"+dto.getName()+"', '"+dto.getPassword()+"', '"+dto.getJob()+"', '"
				+dto.getTell_1()+"', '"+dto.getTell_2()+"', '"+dto.getTell_3()+"', '"+dto.getMobile()+"', '"
				+dto.getEmail()+"', '"+dto.getReg_date()+"','"+dto.getPwlength()+"')";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQL: "+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}
	
    public String encryptSHA256(String value) throws NoSuchAlgorithmException{
        String encryptData ="";
         
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(value.getBytes());
 
        byte[] digest = sha.digest();
        for (int i=0; i<digest.length; i++) {
            encryptData += Integer.toHexString(digest[i] &0xFF).toUpperCase();
        }
         
        return encryptData;
    }
}
