package p_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class J0214_dao {
	private Connection con;
//	접속 상태를 저장
	private PreparedStatement ps;
//	쿼리문을 담아 보내기 위한 method가 포함
	private ResultSet rs;
//	출력문이 해당 형식으로 출력된다.

	String getName(String id){
		String name = "";
		String query = "select * from member where id='"+id+"'";
//		\r \n = 줄 바꿔서 두줄로 찍기 위한 역슬래시 태그.
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
//			next method - rs에 결과가 담겨있으면 return을 true로 한다. - 행이 존재하면 true
				name = rs.getString(2);
//				name = rs.getString("name");
				
//				getString : rs의 값중 String 값을 parsing - index와 label로 선택가능
//				index - column의 순서 (name, area, id .... 에서 1이면 name값을 return)
//				label - column의 제목 (NAME이나 AREA 같은거) - String이므로 쌍따옴표에 넣어서 보내줘야한다.
//				에러 나면 부적합한 열이름 이라는 Exception이 나온다.
//				query문에 as ~로 column 이름을 바꿔버리면, getString 할때도 똑같이 바꿔줘야 한다.
			} else System.out.println("없는 ID입니다.");
		} catch (SQLException e) {
			System.out.println("getName() :"+query);
//			오류난 원인을 찾기위해서 query문을 return한다.
			e.printStackTrace();
		} finally {
			DBConnection.closeDB(con, ps, rs);
//			접속이 성공하든 말든 무조건 DB 접속은 끊어야한다.
		}
		
		return name;
	}
}
