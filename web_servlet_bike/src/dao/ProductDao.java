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
	
	public int getDiscount(String p_no) {
		int k = 0;
		String sql = "select discount from bike_연석모_product where p_no='"+p_no+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				k = rs.getInt("discount");
			}
		}catch(SQLException e) {
			System.out.println("productBuy:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}return k;
	}

	public ProductDto productBuy(String p_no) {
		ProductDto dto = null;
		String sql = "select p_name, price, attach, discount from bike_연석모_product where p_no='"+p_no+"'";
		DecimalFormat df = new DecimalFormat("###,###");
				
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String p_name = rs.getString("p_name");
				String price = rs.getString("price");
				int iPrice = Integer.parseInt(price);
				price = df.format(Integer.parseInt(price));
				String attach = rs.getString("attach");
				String discount = rs.getString("discount");
				int iDiscount = 100-Integer.parseInt(discount);
				iPrice = (int)(iPrice*((double)iDiscount/100));
				discount = df.format(iPrice);
				
				dto = new ProductDto(p_no, p_name, discount, "", attach, "", "", "", "", price, "", "", 0, "", "", "", "");
			}
		}catch(SQLException e) {
			System.out.println("productBuy:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public void getHit(String no) {
		String sql = "update bike_연석모_product set hit=hit+1 where p_no='"+no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			int k = ps.executeUpdate();
			if(k!=1) System.out.println("조회수 증가 오류");
		}catch(SQLException e) {
			System.out.println("getHit:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
	}

	public ArrayList<String[]> getMainImage(){
		ArrayList<String[]> arr = new ArrayList<>();
		String sql = "select p_no, attach, price, p_name from bike_연석모_product order by p_level desc, reg_date desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			for(int k=0; k<4; k++) {
				rs.next();
				String p_no = rs.getString("p_no");
				String attach = rs.getString("attach");
				String price = rs.getString("price");
				String p_name = rs.getString("p_name");
				String[] str = {p_no,attach,p_name,price};
				arr.add(str);
			}
		}catch(SQLException e) {
			System.out.println("getMainImage:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
	
	public int updateDB(ProductDto dto) {
		int k = 0;
		String sql = "update bike_연석모_product set p_name='"+dto.getP_name()+"', p_content='"+dto.getP_content()+"', p_tag='"+dto.getP_tag()+"', "
					+ "attach='"+dto.getAttach()+"', p_size_w="+dto.getP_size_w()+", p_size_l="+dto.getP_size_l()+", p_size_h="+dto.getP_size_h()+", "
					+ "p_weight="+dto.getP_weight()+", price="+dto.getPrice()+", p_level="+dto.getP_level()+", c_name='"+dto.getC_name()+"', "
					+ "update_id='"+dto.getUpdate_id()+"', update_date=to_date('"+dto.getUpdate_date()+"','yyyy-mm-dd hh24:mi:ss'), "
					+ "discount='"+dto.getReg_date()+"' where p_no='"+dto.getP_no()+"'";
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
	
	public int deleteDB(String p_no) {
		int k = 0;
		String sql = "delete bike_연석모_product where p_no = '"+p_no+"'";
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

	public ProductDto anotherViewDB(String p_no, String gubun) {
		ProductDto dto = null;
		String sql = "select p_no, p_name from bike_연석모_product where p_no ";
		if(gubun.equals("pre")) sql+= "< '"+p_no+"' order by p_no desc";
		else if(gubun.equals("pro")) sql+= "> '"+p_no+"' order by p_no asc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String newNo = rs.getString("p_no");
				String p_name = rs.getString("p_name");
				dto = new ProductDto(newNo, p_name, "", "", "", "", "", "", "", "", "", "", 0, "", "", "", "");
			}
		}catch(SQLException e) {
			System.out.println("anotherViewDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	public ProductDto viewDB(String p_no) {
		ProductDto dto = null;
		String sql = "select p.p_name, p.hit, t.tag_name as p_tag, p.p_level, p.attach, p.p_content, p.p_size_w, p.discount, "
					+ "p.p_size_l, p.p_size_h, p.p_weight, p.c_name, p.price, r.name as reg_name, to_char(p.reg_date,'yyyy-mm-dd') as reg_date, "
					+ "u.name as update_name, to_char(p.update_date,'yyyy-mm-dd hh24:mi:ss') as update_date from bike_연석모_product p, "
					+ "bike_연석모_product_tag t, bike_연석모_member r, bike_연석모_member u where r.id = p.reg_id and ((u.id = p.update_id) or (u.id = '000')) "
					+ "and p.p_tag = t.tag_code and p.p_no = '"+p_no+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			if(rs.next()) {
				int hit = rs.getInt("hit");
				String p_name = rs.getString("p_name");
				String p_tag = rs.getString("p_tag");
				String p_level = rs.getString("p_level");
				String attach = rs.getString("attach");
				String p_content = rs.getString("p_content");
				String p_size_w = rs.getString("p_size_w");
				String p_size_l = rs.getString("p_size_l");
				String p_size_h = rs.getString("p_size_h");
				String p_weight = rs.getString("p_weight");
				String c_name = rs.getString("c_name");
				
				String price = rs.getString("price");
				int iPrice = Integer.parseInt(price);
				String discount = rs.getString("discount");
				int iDiscount = 100-Integer.parseInt(discount);
				Double dPrice = iPrice*((double)iDiscount/100);
				
				price = df.format(iPrice);
				discount = df.format(dPrice);
				
				String reg_name = rs.getString("reg_name");
				String reg_date = rs.getString("reg_date");
				String update_name = rs.getString("update_name");
				String update_date = rs.getString("update_date");
				dto = new ProductDto(p_no, p_name, p_content, p_tag, attach, p_size_w, p_size_l, p_size_h, p_weight, price, p_level, c_name, reg_date, reg_name, update_name, update_date, discount, hit);
			}
		}catch(SQLException e) {
			System.out.println("viewDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}

	public int deleteTagDB(String tag_code) {
		int k = 0;
		String sql1 = "update bike_연석모_product set p_tag='T000' where p_tag='"+tag_code+"'";
		String sql2 = "delete bike_연석모_product_tag where tag_code='"+tag_code+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql1);
			k = ps.executeUpdate();
			ps = con.prepareStatement(sql2);
			k += ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("insertTagDB:sql1"+sql1+" //// sql2:"+sql2);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k/2;
	}
	public String getMaxTag() {
		String result = null;
		String sql = "select max(tag_code) as tag_code from bike_연석모_product_tag";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getString("tag_code");
			}
		}catch(SQLException e) {
			System.out.println("insertTagDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		result = result.substring(1);
		int iResult = Integer.parseInt(result);
		iResult++;
		DecimalFormat df = new DecimalFormat("T000");
		result = df.format(iResult);
		return result;
	}
	
	public int insertTagDB(String tag_name, String tag_code) {
		int k = 0;
		String sql = "insert into bike_연석모_product_tag (tag_name, tag_code) values('"+tag_name+"','"+tag_code+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("insertTagDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public int updateTagDB(String tag_name, String tag_code) {
		int k = 0;
		String sql = "update bike_연석모_product_tag set tag_name='"+tag_name+"' where tag_code='"+tag_code+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("updateTagDB:"+sql);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return k;
	}
	
	public ArrayList<ProductDto> listDB(String select, String search, String tag, int start, int end){
		ArrayList<ProductDto> arr = new ArrayList<ProductDto>();
		String subSql = "select p_no, attach, p_name, p_level, price, reg_date, hit, discount from bike_연석모_product where "+select+" like '%"+search+"%' ";
		if(tag!=null && !tag.equals("")) subSql += "and p_tag='"+tag+"' ";
		String sql = "select * from (select rownum as rnum, tbl.* from ("+subSql+"order by p_level desc, reg_date desc ) tbl) where rnum>="+start+" and rnum<="+end+" order by p_level desc, reg_date desc ";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			DecimalFormat df = new DecimalFormat("###,###");
			while(rs.next()) {
				String p_no = rs.getString("p_no");
				String attach = rs.getString("attach");
				String p_name = rs.getString("p_name");
				String p_level = rs.getString("p_level");
				String price = rs.getString("price");
				Long iPrice = Long.parseLong(price);
				int hit = rs.getInt("hit");
				String discount = rs.getString("discount");
				int iDiscount = 100-Integer.parseInt(discount);
				Double dPrice = iPrice*((double)iDiscount/100);
				price = df.format(iPrice);
				discount = df.format(dPrice);
			
				ProductDto dto = new ProductDto(p_no, p_name, discount, "", attach, "", "", "", "", price, p_level, "", hit, "", "", "", "");
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

	public int totalCountDB(String select, String search, String tag) {
		int k = 0;
		String sql = "select count(*) as count from bike_연석모_product where "+select+" like '%"+search+"%' " ;
		if(tag!=null && !tag.equals("")) sql += "and p_tag='"+tag+"' ";
				
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
			DBConnection.closeDB(con, ps, rs);
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
			DBConnection.closeDB(con, ps, rs);
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
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}
}
