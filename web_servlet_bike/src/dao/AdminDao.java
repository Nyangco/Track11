package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.CommonUtil;
import common.DBConnection;
import dto.AdminDto;
import dto.CustomerDto;

public class AdminDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	//public CustomerDto(String id, String name, String product_number, String price) {
	//ArrayList<ArrayList<String>> arr = dao.getAllStatics();
	public ArrayList<ArrayList<String>> getCC(String month){
		ArrayList<ArrayList<String>> arr = new ArrayList<>();
		String sql4="select id, sum(s_price) as s_price from bike_연석모_product_sale where status='6' "
					+ "and to_char(purchase_date,'yyyy-mm')='"+month+"' group by id";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql4);
			rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList<String> sub = new ArrayList<>();
				String id = rs.getString("id");
				String s_price = rs.getString("s_price");
				sub.add(id);
				sub.add(s_price);
				arr.add(sub);
			}
		}catch(SQLException e) {
			System.out.println("getCC:"+sql4);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return arr;
	}
	
	public ArrayList<ArrayList<String>> getCC(){
		ArrayList<ArrayList<String>> arr = new ArrayList<>();
		String sql4="select id, sum(s_price) as s_price from bike_연석모_product_sale where status='6' group by id";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql4);
			rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList<String> sub = new ArrayList<>();
				String id = rs.getString("id");
				String s_price = rs.getString("s_price");
				sub.add(id);
				sub.add(s_price);
				arr.add(sub);
			}
		}catch(SQLException e) {
			System.out.println("getCC:"+sql4);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return arr;
	}
	
	public ArrayList<ArrayList<String>> getPC(String month){
		ArrayList<ArrayList<String>> arr = new ArrayList<>();
		String sql3="select p_no, count(p_no) as count from bike_연석모_product_sale where status='6' "
					+ "and to_char(purchase_date,'yyyy-mm')='"+month+"' group by p_no";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql3);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_no = rs.getString("p_no");
				String count = rs.getString("count");
				ArrayList<String> sub = new ArrayList<>();
				sub.add(p_no);
				sub.add(count);
				arr.add(sub);
			}
		}catch(SQLException e) {
			System.out.println("getPC:"+sql3);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return arr;
	}
	
	public ArrayList<ArrayList<String>> getPC(){
		ArrayList<ArrayList<String>> arr = new ArrayList<>();
		String sql3="select p_no, count(p_no) as count from bike_연석모_product_sale where status='6' group by p_no";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql3);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_no = rs.getString("p_no");
				String count = rs.getString("count");
				ArrayList<String> sub = new ArrayList<>();
				sub.add(p_no);
				sub.add(count);
				arr.add(sub);
			}
		}catch(SQLException e) {
			System.out.println("getPC:"+sql3);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return arr;
	}
	
	public ArrayList<String> getTC_TS(String month){
		ArrayList<String> arr = new ArrayList<>();
		String sql1="select count(*) as count from bike_연석모_product_sale where status='6' "
					+ "and to_char(purchase_date,'yyyy-mm')='"+month+"'";
		String sql2="select sum(s_price) as s_price from bike_연석모_product_sale where status='6' "
					+ "and to_char(purchase_date,'yyyy-mm')='"+month+"'"; 
		
		try {
			con = DBConnection.getConnection();
			
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			if(rs.next()) {
				String count = rs.getString("count");
				arr.add(count);
			}
			
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			if(rs.next()) {
				String price = rs.getString("s_price");
				arr.add(price);
			}
		}catch(SQLException e) {
			System.out.println("getTC_TS:\n sql1:"+sql1+"\n sql2:"+sql2);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return arr;
	}
	
	public ArrayList<String> getTC_TS(){
		ArrayList<String> arr = new ArrayList<>();
		String sql1="select count(*) as count from bike_연석모_product_sale where status='6'";
		String sql2="select sum(s_price) as s_price from bike_연석모_product_sale where status='6'"; 
		
		try {
			con = DBConnection.getConnection();
			
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			if(rs.next()) {
				String count = rs.getString("count");
				arr.add(count);
			}
			
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			if(rs.next()) {
				String price = rs.getString("s_price");
				arr.add(price);
			}
		}catch(SQLException e) {
			System.out.println("getTC_TS:\n sql1:"+sql1+"\n sql2:"+sql2);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return arr;
	}
	
	public CustomerDto getPurchase_view(String purchase_number) {
		CustomerDto dto = null;
		String sql = "select id, p_no, status, s_email, to_char(purchase_date,'yyyy-mm-dd hh24:mi:ss') as purchase_date, "
					+ "s_price, s_name, s_mobile_1, s_mobile_2, s_mobile_3, shipping_method, s_address, comments, "
					+ "buy_method, credit_1, credit_2, credit_3, credit_4, cvc, transfer_name, refund "
					+ "from bike_연석모_product_sale where purchase_number = '"+purchase_number+"'";
		String subsql = "";

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("s_name");
				String mobile_1 = rs.getString("s_mobile_1");
				String mobile_2 = rs.getString("s_mobile_2");
				String mobile_3 = rs.getString("s_mobile_3");
				String email = rs.getString("s_email");
				String shipping_method = rs.getString("shipping_method");
				String address = rs.getString("s_address");
				String comment = rs.getString("comments");
				String buy_method = rs.getString("buy_method");
				String credit_1 = rs.getString("credit_1");
				String credit_2 = rs.getString("credit_2");
				String credit_3 = rs.getString("credit_3");
				String credit_4 = rs.getString("credit_4");
				String cvc = rs.getString("cvc");
				String transfer_name = rs.getString("transfer_name");
				String product_number = rs.getString("p_no");
				String status = rs.getString("status");
				String price = rs.getString("s_price");
				String purchase_date = rs.getString("purchase_date");
				
				subsql = "select name from bike_연석모_member where id='"+id+"'";
				ps = con.prepareStatement(subsql);
				rs = ps.executeQuery();
				if(rs.next()) {
					String m_name = rs.getString("name");
					dto = new CustomerDto(id, name, mobile_1, mobile_2, mobile_3, email, shipping_method, address, comment, 
							buy_method, credit_1, credit_2, credit_3, credit_4, cvc, transfer_name, purchase_number, 
							product_number, status, price, purchase_date,m_name);
				}
			}
		}catch(SQLException e) {
			System.out.println("getPurchase_view \nsql:"+sql+"\n subsql:"+subsql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public ArrayList<String> purchase_change(String purchase_number) {
		ArrayList<String> arr = new ArrayList<String>();
		String sql = "select p.p_name, p.p_no, s.refund from bike_연석모_product p, bike_연석모_product_sale s where "
					+ "p.p_no = s.p_no and s.purchase_number='"+purchase_number+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String p_name = rs.getString("p_name");
				arr.add(p_name);
				String p_no = rs.getString("p_no");
				arr.add(p_no);
				String refund = rs.getString("refund");
				arr.add(refund);
			}
		}catch(SQLException e) {
			System.out.println("purchase_change:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	//int k = dao.updateStatusDB(purchase_number,change_status);
	public int updateStatusDB(String purchase_number, String change_status) {
		int k = 0;
		String sql = "update bike_연석모_product_sale set status='"+change_status+"' where purchase_number='"+purchase_number+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("updateStatusDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public int updateDB(String id, String sLevel) {
		int k = 0;
		String sql = "update bike_연석모_member set sLevel='"+sLevel+"' where id='"+id+"'";
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

	public int deleteDB(String id) {
		int k = 0;
		String sql = "update bike_연석모_member set exit_date = to_date('"+CommonUtil.getToday()+"','yyyy-mm-dd') where id='"+id+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("deleteDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public AdminDto ViewDB(String id) {
		AdminDto dto = null;
		String sql = "select sLevel, name, area, address, mobile_1, mobile_2, mobile_3, gender, hobby_travel, hobby_reading, "
					+ "hobby_sports, to_char(reg_date,'yyyy-mm-dd') as reg_date, to_char(update_date,'yyyy-mm-dd hh24:mi:ss') as update_date, "
					+ "to_char(last_login_date,'yyyy-mm-dd hh24:mi:ss') as last_login_date, to_char(exit_date,'yyyy-mm-dd') as exit_date, "
					+ "email, password_len from bike_연석모_member where id = '"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String sLevel = rs.getString("sLevel");
				String name = rs.getString("name");
				int pwLen = rs.getInt("password_len");
				String area = rs.getString("area");
				String address = rs.getString("address");
				String mobile_1 = rs.getString("mobile_1");
				String mobile_2 = rs.getString("mobile_2");
				String mobile_3 = rs.getString("mobile_3");
				String gender = rs.getString("gender");
				String hobby_travel = rs.getString("hobby_travel");
				String hobby_reading = rs.getString("hobby_reading");
				String hobby_sports = rs.getString("hobby_sports");
				String reg_date = rs.getString("reg_date");
				String update_date = rs.getString("update_date");
				String last_login_date = rs.getString("last_login_date");
				String exit_date = rs.getString("exit_date");
				String email = rs.getString("email");
				dto = new AdminDto(id, sLevel, name, area, address, mobile_1, mobile_2, mobile_3, gender, hobby_travel, hobby_reading, hobby_sports, reg_date, update_date, last_login_date, exit_date, email, pwLen);
			}
		}catch(SQLException e) {
			System.out.println("viewDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
		
	public ArrayList<AdminDto> listDB(String select, String search, int start, int end) {
		ArrayList<AdminDto> arr = new ArrayList<AdminDto>();
		String subSql = "select id, slevel, name, email, area, mobile_1, mobile_2, mobile_3, to_char(reg_date,'yyyy-mm-dd') as reg_date, "
					+ "to_char(last_login_date,'yyyy-mm-dd hh24:mi:ss') as last_login_date, to_char(exit_date,'mm-dd') as exit_date "
					+ "from bike_연석모_member where "+select+" like '%"+search+"%'";
		String sql = "select * from (select rownum as rnum, tbl.* from ("+subSql+") tbl) where rnum>="+start+" and rnum<="+end+" order by reg_date desc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String sLevel = rs.getString("sLevel");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String area = rs.getString("area");
				String mobile_1 = rs.getString("mobile_1");
				String mobile_2 = rs.getString("mobile_2");
				String mobile_3 = rs.getString("mobile_3");
				String reg_date = rs.getString("reg_date");
				String last_login_date = rs.getString("last_login_date");
				String exit_date = rs.getString("exit_date");
				AdminDto dto = new AdminDto(id, sLevel, name, area, "", mobile_1, mobile_2, mobile_3, "", "", "", "", reg_date, "", last_login_date, exit_date, email, 0);
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
		String sql = "select count(*) as count from bike_연석모_member where "+select+" like '%"+search+"%'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("count");
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
