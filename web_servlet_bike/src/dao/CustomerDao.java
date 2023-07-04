package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.CustomerDto;

public class CustomerDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<CustomerDto> listDB(String select, String search, int start, int end){
		ArrayList<CustomerDto> arr = new ArrayList<CustomerDto>();
		String subSql = "select purchase_number, status, p_no, shipping_method, to_char(purchase_date,'yyyy-mm-dd hh24:mi:ss') as purchase_date "
					+ "from bike_연석모_product_sale where "+select+" like '%"+search+"%' "
					+ "order by status desc, purchase_date desc";
		String sql = "select * from (select rownum as rnum, tbl.* from ("+subSql+") tbl) where rnum>="+start+" and rnum<="+end;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String purchase_number = rs.getString("purchase_number");
				String status = rs.getString("status");
				String p_no = rs.getString("p_no");
				String shipping_method = rs.getString("shipping_method");
				String purchase_date = rs.getString("purchase_date");
				CustomerDto dto = new CustomerDto("", "", "", "", "", "", shipping_method, "", "", "", "", "", "", "", "", "", purchase_number, p_no, status, "", purchase_date);
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
		String sql = "select count(*) as count from bike_연석모_product_sale where "+select+" like '%"+search+"%'";
		
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
		}return k;
	}
	
	public int refundDB(String purchase_number, String refund_change, String why, String change) {
		int k = 0;
		String sql = "";
		if(refund_change.equals("refund"))
		sql = "update bike_연석모_product_sale set status='8', refund='"+why+"' where purchase_number='"+purchase_number+"'";
		else if(refund_change.equals("change")) 
		sql = "update bike_연석모_product_sale set status='9', refund='"+change+"' where purchase_number='"+purchase_number+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("refundDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}
	
	public int confirmDB(String purchase_number) {
		int k = 0;
		String sql = "update bike_연석모_product_sale set status='6' where purchase_number='"+purchase_number+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("confirmDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}
	
	public int cancelDB(String purchase_number) {
		int k = 0;
		String sql = "update bike_연석모_product_sale set status='8' where purchase_number='"+purchase_number+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("cancelDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}
	
	public CustomerDto viewDB(String purchase_number) {
		CustomerDto dto = null;
		DecimalFormat df = new DecimalFormat("###,###");
		String subSql = "select status,p_no,to_char(purchase_date,'yyyy-mm-dd hh24:mi:ss')as purchase_date,s_price,"
					+ "shipping_method,s_name,s_email,s_mobile_1,s_mobile_2,s_mobile_3,s_address,comments,buy_method,"
					+ "transfer_name from bike_연석모_product_sale where purchase_number = '"+purchase_number+"'";
		String sql = "select tbl.*, p.p_name from ("+subSql+") tbl, bike_연석모_product p where p.p_no=tbl.p_no";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String status = rs.getString("status");
				String p_name = rs.getString("p_name");
				String purchase_date = rs.getString("purchase_date");
				int iPrice = rs.getInt("s_price");
				String price = df.format(iPrice);
				String shipping_method = rs.getString("shipping_method");
				String name = rs.getString("s_name");
				String email = rs.getString("s_email");
				String mobile_1 = rs.getString("s_mobile_1");
				String mobile_2 = rs.getString("s_mobile_2");
				String mobile_3 = rs.getString("s_mobile_3");
				String address = rs.getString("s_address");
				String comment = rs.getString("comments");
				String buy_method = rs.getString("buy_method");
				String transfer_name = rs.getString("transfer_name");
				dto = new CustomerDto("", name, mobile_1, mobile_2, mobile_3, email, shipping_method, address, comment, buy_method, "", "", "", "", "", transfer_name, purchase_number, p_name, status, price, purchase_date);
			}
		}catch(SQLException e) {
			System.out.println("viewDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public String getP_no(String search) {
		String result = null;
		String sql1 = "select count(*) as count from bike_연석모_product where p_name like '%"+search+"%'";
		String sql2 = "select p_no from bike_연석모_product where p_name like '%"+search+"%'";

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt("count")!=1) {
					result = "해당하는 제품명이 너무 많습니다.";
				}else {
					con = DBConnection.getConnection();
					ps = con.prepareStatement(sql2);
					rs = ps.executeQuery();
					if(rs.next()) {
						result = rs.getString("p_no");
					}
				}
			}
		}catch(SQLException e) {
			System.out.println("getP_no_sql1:"+sql1+"\n getP_no_sql2:"+sql2);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	public ArrayList<CustomerDto> listDB(String select, String search, int start, int end, String id){
		ArrayList<CustomerDto> arr = new ArrayList<CustomerDto>();
		DecimalFormat df = new DecimalFormat("###,###");
		String subSql = "select s.purchase_number, p.p_name, to_char(s.purchase_date,'yyyy-mm-dd hh24:mi:ss') as purchase_date, "
					+ "s.s_price, s.status from bike_연석모_product_sale s, bike_연석모_product p where "+select+" "
					+ "like '%"+search+"%' and s.p_no=p.p_no and s.id = '"+id+"' order by status asc, purchase_date desc";
		String sql = "select * from (select rownum as rnum, tbl.* from ("+subSql+") tbl) "
					+ "where rnum>="+start+" and rnum<="+end;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String purchase_number = rs.getString("purchase_number");
				String p_name = rs.getString("p_name");
				String purchase_date = rs.getString("purchase_date");
				long iPrice = rs.getLong("s_price");
				String price = df.format(iPrice);
				String status = rs.getString("status");
				CustomerDto dto = new CustomerDto(purchase_number, p_name, status, price, purchase_date);
				//CustomerDto dto = new CustomerDto(purchase_number, product_number, status, price, purchase_date)
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
	
	public int totalCountDB(String select, String search, String id) {
		int k = 0;
		String sql = "select count(*) as count from bike_연석모_product_sale where "+select+" like '%"+search+"%' and id='"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) k = rs.getInt("count");
		}catch(SQLException e) {
			System.out.println("totalCountDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public int insertDB(CustomerDto dto) {
		int k = 0;
		String sql = "insert into bike_연석모_product_sale (id,s_name,s_mobile_1,s_mobile_2,s_mobile_3,s_email,shipping_method,"
					+ "s_address,comments,buy_method,credit_1,credit_2,credit_3,credit_4,cvc,transfer_name,purchase_number,"
					+ "p_no,status,s_price,purchase_date) values('"+dto.getId()+"','"+dto.getName()+"','"
					+ dto.getMobile_1()+"','"+dto.getMobile_2()+"','"+dto.getMobile_3()+"','"+dto.getEmail()+"','"
					+ dto.getShipping_method()+"','"+dto.getAddress()+"','"+dto.getComment()+"','"+dto.getBuy_method()+"','"
					+ dto.getCredit_1()+"','"+dto.getCredit_2()+"','"+dto.getCredit_3()+"','"+dto.getCredit_4()+"','"
					+ dto.getCvc()+"','"+dto.getTransfer_name()+"','"+dto.getPurchase_number()+"','"
					+ dto.getProduct_number()+"','"+dto.getStatus()+"','"+dto.getPrice()+"',to_date('"
					+ dto.getPurchase_date()+"','yyyy-mm-dd hh24:mi:ss'))";
		
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
	
	public String getMaxNo(String today) {
		String result = null;
		String sql = "select nvl(max(purchase_number),'S"+today+"000') as purchase_number from bike_연석모_product_sale "
					+ "where purchase_number like '%"+today+"%'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("purchase_number");
			}
		}catch(SQLException e) {
			System.out.println("getMaxNo:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		int iResult = Integer.parseInt(result.substring(1));
		iResult++;
		DecimalFormat df = new DecimalFormat("S000000000");
		result = df.format(iResult);
		return result;
	}
	
}
