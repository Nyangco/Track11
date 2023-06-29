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
		String subSql = "select s.purchase_number, p.p_name, to_char(s.purchase_date,'yyyy-mm-dd hh24:mi:ss') as purchase_date, "
					+ "s.s_price, s.status from bike_연석모_product_sale s, bike_연석모_product p where "+select+" "
					+ "like '%"+search+"%' and s.p_no=p.p_no order by status asc, purchase_date desc";
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
				String price = rs.getString("s_price");
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
	
	public int totalCountDB(String select, String search) {
		int k = 0;
		String sql = "select count(*) as count from bike_연석모_product_sale where "+select+" like '%"+search+"%'";
		
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
		DecimalFormat df = new DecimalFormat("S#########");
		result = df.format(iResult);
		return result;
	}
	
}
