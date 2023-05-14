package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class J0215_dao {

//	SQL 접속을 위한 field
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;	
	
//	member의 id를 입력해서 SQL에서 정보를 조회해오는 method
	J0214_dto getMemberInfo(String id){
		J0214_dto dto = null;
		
		String query="select name,area,age from member where id='"+id+"'";
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String name=rs.getString("name");
				String area=rs.getString("area");
				int age=rs.getInt("age");
				
				dto = new J0214_dto(id,name,area,age,1);
			}
			
		}catch(SQLException e) {
			System.out.println("Query : "+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	
//	특정 query문을 사용하여 table의 정보를 모두 긁어오는 method
	ArrayList<J0214_dto> getMemberList(String queryAdd){
		
		ArrayList<J0214_dto> dtos = new ArrayList<>();
		String query ="select m.id,m.name,a.area_name,m.age "+
				"from member m,areacommon a "+
				"where m.area=a.area_code "+queryAdd;
		int num=1;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
//			1행이 존재 하느냐?
//			next문이 다음 줄로 옮겨주는 역할 (\n)
//			=> 다음 행으로 옮긴다 / 행이 존재하면 true, 행의 이동에 실패하면 false를 반환한다.
				String id = rs.getString("id");
				String name = rs.getString("name");
				String area = rs.getString("area_name");
				int age = rs.getInt("age");
				J0214_dto dto = new J0214_dto(id,name,area,age,num);
				dtos.add(dto);
				num++;
			}
		}catch (SQLException e) {
			System.out.println("Query :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
//	출력부의 목차를 출력하는 method
	void printIndex() {
		System.out.println("-----------------------------------");
		System.out.println("순번\tID\t성명\t지역\t나이");
		System.out.println("-----------------------------------");
	}
	
//	출력부에서 각각의 요소를 출력하는 method
	void printDto(J0214_dto dto) {
		System.out.print(dto.getNum()+"\t");
		System.out.print(dto.getId()+"\t");
		System.out.print(dto.getName()+"\t");
		System.out.print(dto.getArea()+"\t");
		System.out.println(dto.getAge());
	}
	
//	ArrayList를 받아와서 모든 요소를 출력하기 위한 method
	void printArrList(ArrayList<J0214_dto> dtos) {
		System.out.println("===================================");
		System.out.println("총 인원 : "+dtos.size());
		printIndex();
		if(dtos.size()!=0) {
			for(int k=0; k<dtos.size(); k++) {
				printDto(dtos.get(k));
			}
		} else System.out.println("검색 결과 없음");
		System.out.println("===================================");
	}
}
	
	

