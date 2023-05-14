package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnection;
import dto.StudentDto;

public class StudentDao {
	
	Connection         con = null;
	PreparedStatement  ps  = null;
	ResultSet          rs  = null;
	
	//총점
	public int getTotal(String k,String e, String m) {
		int total = Integer.parseInt(k)+
					Integer.parseInt(e)+
					Integer.parseInt(m);
		return total;
	}
	//평균
	public double getAve(int total,int count) {
		DecimalFormat df = new DecimalFormat("##.0#");
		double ave = total/(double)count;
		String result = df.format(ave);
		
		return Double.parseDouble(result);
	}
	//중복체크
	public int getCheck(String syear,String sclass, String sno) {
		int count = 0;
		String query = "select count(*)as count from h_김용석_student \r\n" + 
					   "where syear = '"+syear+"'\r\n" + 
					   "and sclass = '"+sclass+"'\r\n" + 
					   "and sno = '"+sno+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return count;
	}
	//등록
	public int StudentSave(StudentDto dto) {
		int result = 0;
		String query = "insert into h_김용석_student\r\n" + 
					   "(syear,sclass,sno,name,kor,eng,mat,total,ave)\r\n" + 
					   "values('"+dto.getSyear()+"','"+dto.getSclass()+"','"+dto.getSno()+"','"+dto.getName()+"',"+
					   			dto.getKor()+","+dto.getEng()+","+dto.getMat()+","+
					   			dto.getTotal()+","+dto.getAve()+")";
		
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return result;
	}
	//리스트 
	public ArrayList<StudentDto> getStudentList(String grade,String gubun,String search){
		ArrayList<StudentDto> arr = new ArrayList<>();
		String query="";
		if(!grade.equals("all")) {
			query = "select syear,sclass,sno,name from h_김용석_student\r\n" + 
				    "where syear = '"+grade+"'\r\n" + 
					"and "+gubun+" like '%"+search+"%'\r\n" + 
				    "order by syear,sclass, to_number(sno)";
		}else {
			query = "select syear,sclass,sno,name from h_김용석_student\r\n" + 
					"where "+gubun+" like '%"+search+"%'\r\n" + 
					"order by syear,sclass,to_number(sno)";
		}
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String syear = rs.getString("syear");
				String sclass = rs.getString("sclass");
				String sno = rs.getString("sno");
				String name = rs.getString("name");
				
				StudentDto dto = new StudentDto(syear,sclass,sno,name);
				arr.add(dto);
				
				
			}
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		return arr;
	}
	//상세조회
		public StudentDto getStudentView(String syear, String sclass, String sno) {
				StudentDto dto = null;
				String query = "select syear,sclass,sno,name,kor,eng,mat,total,to_char(ave,'999.99')as ave\r\n" + 
							   "from h_김용석_student\r\n" + 
							   "where syear = '"+syear+"'\r\n" + 
							   "and sclass = '"+sclass+"'\r\n" + 
							   "and sno = '"+sno+"' ";
				try {
					con = DBConnection.getConnection();
					ps = con.prepareStatement(query);
					rs = ps.executeQuery();
					
					if(rs.next()) {
						String name = rs.getString("name");
						int kor = rs.getInt("kor");
						int eng = rs.getInt("eng");
						int mat = rs.getInt("mat");
						int total = rs.getInt("total");
						double ave = rs.getDouble("ave");
						
						dto = new StudentDto(syear, sclass, sno, name, kor, eng, mat, total, ave);
					}
				}catch(Exception e) {
					System.out.println("쿼리오류"+query);
					e.printStackTrace();
				}finally {
					DBConnection.closeDB(con, ps, rs);
				}
				
				
				return dto;
		}
		//수정저장/
	public int studentUpdate(StudentDto dto) {
		int result = 0;
		String query = "update h_김용석_student\r\n" + 
					   "    set name = '"+dto.getName()+"',\r\n" + 
					   "        kor = "+dto.getKor()+",\r\n" + 
					   "        eng = "+dto.getEng()+",\r\n" + 
					   "        mat = "+dto.getMat()+",\r\n" + 
					   "        total = "+dto.getTotal()+",\r\n" + 
					   "        ave = "+dto.getAve()+"\r\n" + 
					   "where syear = '"+dto.getSyear()+"'\r\n" + 
					   "and sclass = '"+dto.getSclass()+"'\r\n" + 
					   "and sno = '"+dto.getSno()+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
				
				
		return result;
	}
	public int studentDelete(String syear,String sclass,String sno) {
		int result = 0;
		String query = "delete from h_김용석_student\r\n" + 
				       "where syear = '"+syear+"'\r\n" + 
				       "and sclass = '"+sclass+"'\r\n" + 
				       "and sno = '"+sno+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("쿼리오류"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		
		
		return result;
	}
}
