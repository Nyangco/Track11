package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.ProductDto;

public class ProductDao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<ProductDto> listDB(String select, String search, String tag, int start, int end){
		ArrayList<ProductDto> arr = new ArrayList<ProductDto>();
		String subSql = "select p_no, attach, p_name, p_level, price from bike_연석모_product where "+select+" like '%"+search+"%'";
		if(tag!=null) subSql += "and p_tag='"+tag+"' ";
		String sql = "select * from (select rownum as rnum, tbl.* from ("+subSql+") tbl) where rnum>="+start+" and rnum<="+end+" order by p_level asc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_no = rs.getString("p_no");
				String attach = rs.getString("attach");
				String p_name = rs.getString("p_name");
				String p_level = rs.getString("p_level");
				String price = rs.getString("price");
				if(price.length()>3) {
					
				}
				
				ProductDto dto = new ProductDto(p_no, p_name, "", "", attach, "", "", "", "", price, p_level, "", 0, "", "", "", "");
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("listDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.getConnection();
		}
		return arr;
	}

	public int totalCountDB(String select, String search, String tag) {
		int k = 0;
		String sql = "select count(*) as count from bike_연석모_product where "+select+" like '%"+search+"%' " ;
		if(tag!=null) sql += "and p_tag='"+tag+"' ";
				
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
			DBConnection.getConnection();
		}
		return k;
	}
	
	public int insertDB(ProductDto dto) {
		int k = 0;
		String sql = "insert into bike_연석모_product (p_no, p_name, p_content, p_tag, attach, p_size_w, p_size_l, p_size_h, p_weight, price, p_level, c_name,"
					+ "reg_date, reg_id) values('"+dto.getP_no()+"','"+dto.getP_name()+"','"+dto.getP_content()+"','"+dto.getP_tag()+"','"+dto.getAttach()+"',"
					+dto.getP_size_w()+","+dto.getP_size_l()+","+dto.getP_size_h()+","+dto.getP_weight()+","+dto.getPrice()+","+dto.getP_level()+",'"+dto.getC_name()+"',"
					+"to_date('"+dto.getReg_date()+"','yyyy-mm-dd'),'"+dto.getReg_id()+"')";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("insertDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.getConnection();
		}
		return k;
	}
	
	public String getMaxNo() {
		String result = null;
		String sql = "select nvl(max(p_no),'P000') as p_no from bike_연석모_product";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("p_no");
			}
		}catch(SQLException e) {
			System.out.println("getMaxNo:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.getConnection();
		}
		result = result.substring(1);
		int iResult = Integer.parseInt(result);
		iResult++;
		DecimalFormat df = new DecimalFormat("P000");
		result = df.format(iResult);
		return result;
	}
	
	public ArrayList<String[]> selectTagDB(){
		ArrayList<String[]> arr = new ArrayList<>();
		String sql = "select tag_code, tag_name from bike_연석모_product_tag";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String tag_code = rs.getString("tag_code");
				String tag_name = rs.getString("tag_name");
				String[] list = {tag_code,tag_name};
				arr.add(list);
			}
		}catch(SQLException e) {
			System.out.println("selectTagDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.getConnection();
		}
		return arr;
	}
}
