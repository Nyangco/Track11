package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class J0216_student_dao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	Scanner sc = new Scanner(System.in);
	
	J0216_student_dto getStudentInfo(String id){
		J0216_student_dto dto = null;
		String query = "select name, kor, eng, mat, total, result"+
						" from e_연석모_student"+
						" where id = '"+id+"'";
		
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
				String result = rs.getString("result");
				dto = new J0216_student_dto(id,name,kor,eng,mat,total,result);
			}
		}catch (SQLException e) {
			System.out.println("Query : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
	int inputNum() {
		int num = -1;
		try {
			num=sc.nextInt();
		}catch(Exception e) {}
		if(num>100 || num<0) {
			System.out.println("점수 입력오류");
			return -1;
		}
		return num;
	}
	
	int deleteDB(String k) {
		int result = 0;
		String query = "delete from e_연석모_student"+
						" where id='"+k+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Query : "+query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
		
	int insertDB(J0216_student_dto dto) {
		int result = 0;
		String query = "insert into e_연석모_student"+
						" values('"+dto.getId()+"',"+
						"'"+dto.getName()+"',"+
						"'"+dto.getKor()+"',"+
						"'"+dto.getEng()+"',"+
						"'"+dto.getMat()+"',"+
						"'"+dto.getTotal()+"',"+
						"'"+dto.getResult()+"')";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println("Query :"+query);
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
		}return result;
	}
	
	String getResult(int total) {
		double ave = total/3.0;
		if(ave>=90 && ave<=100) return "수";
		else if(ave>=80) return "우";
		else if(ave>=70) return "미";
		else if(ave>=60) return "양";
		else if(ave>=0 && ave<60) return "가";
		else return "오류";
	}
	
	void printIndex() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("순번\tid\t이름\t국어\t영어\t수학\t총점\t결과");
		System.out.println("-----------------------------------------------------------");
	}
	
	void printDto(J0216_student_dto dto, int a) {
			System.out.print(a+"\t");
			System.out.print(dto.getId()+"\t");
			System.out.print(dto.getName()+"\t");
			System.out.print(dto.getKor()+"\t");
			System.out.print(dto.getEng()+"\t");
			System.out.print(dto.getMat()+"\t");
			System.out.print(dto.getTotal()+"\t");
			System.out.print(dto.getResult()+"\n");
	}
	
	void printDto(J0216_student_dto dto) {
		printIndex();
		if(dto==null) System.out.println("해당사항 없음");
		printDto(dto,1);
		System.out.println("===========================================================");
	}
	
	void printArrList(ArrayList<J0216_student_dto> arr) {
		System.out.println("===========================================================");
		System.out.println("총원 :"+arr.size());
		printIndex();
		if(arr.size()==0) System.out.println("해당사항 없음");
		for(int k=0; k<arr.size(); k++) {
			printDto(arr.get(k),k+1);
		}
		System.out.println("===========================================================");
	}
	
	ArrayList<J0216_student_dto> getStudent(String query){
		ArrayList<J0216_student_dto> arr = new ArrayList<>();
		
		try {
			
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int total = rs.getInt("total");
				String result = rs.getString("result");
				J0216_student_dto dto = new J0216_student_dto(id,name,kor,eng,mat,total,result);
				arr.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("Query :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return arr;
	}

	public ArrayList<J0216_student_dto> getSearchList(String gubun, String search) {
		ArrayList<J0216_student_dto> dtos = new ArrayList<>();
		
		String query = "select id,name,kor,eng,mat,total,result "+
						" from e_연석모_student"+
						" where "+gubun+" like '%"+search+"%'"+
						" order by id desc";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int total = rs.getInt("total");
				String result = rs.getString("result");
				J0216_student_dto dto = new J0216_student_dto(id,name,kor,eng,mat,total,result);
				dtos.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("Query : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}

	public int updateDB(String id, String column1, String data) {
		int count = 0;
		
		String query = "update e_연석모_student set "+column1+" = '"+data+
				"' where id = '"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			count = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Query :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
	int updateStudent(J0216_student_dto dto) {
		int count=0;
		
		String query = "update e_연석모_student"+
						" set name='"+dto.getName()+
						"', kor="+dto.getKor()+
						",eng="+dto.getEng()+
						",mat="+dto.getMat()+
						",total="+dto.getTotal()+
						",result='"+dto.getResult()+
						"' where id = "+dto.getId();
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			count = ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Query : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return count;
	}
	
}
