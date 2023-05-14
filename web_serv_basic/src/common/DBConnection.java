package common;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;

public class DBConnection {
	
	public static Connection getConnection(){
//		return type이 Connection인 getConnection 이라는 method
		Connection con = null;
		boolean goIng = true;
//		실행과 관련된 전역변수 2개 선언 - connection과 관련된 class type의 변수 1개와 checkSum 형식의 boolean 변수 1개
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			ojdbc6.jar가 설치되어 있는지를 확인하는 방법. - Class class의 forname method는 뒤의 String과 연관된 class나 interface를 return
//			없으면 ClassNotFoundException을 return - catch에 잡히게 된다.
//			ojdbc6.jar 가 JRE에 설치되어 있어야 함 - OracleDB와 Java IDE를 연결해주는 driver file
		} catch (ClassNotFoundException e) {
			goIng = false;
			System.out.println("오라클 드리이버 없음~~");
			e.printStackTrace();
		}
		
		if(goIng){
//		Driver가 없을 때는 실행을 생략한다.
			String db_url		="jdbc:oracle:thin:@jsl-704:1521:xe";
			
//			"jdbc:oracle:thin:@주소:1521:xe"
			String db_user		="track11";
			String db_password	="1234";
			
			try {
//				DriverManager.getConnection 이라는 method가 throws SQLException 처리 되어있어서 try-catch 가 필수요소로 존재한다.
				con = DriverManager.getConnection(db_url, db_user, db_password);
//				getConnection method를 통해 Connection class type이 생성되고, 주소를 con에 return한다.
//				만약 error가 있으면, throws 당하기에 con은 null인 채로이다.
			} catch (SQLException e) {
				try {
					db_url		="jdbc:oracle:thin:@182.217.138.73:1521:xe";
					con = DriverManager.getConnection(db_url, db_user, db_password);
				}catch(SQLException k) {
					System.out.println("DB 계정설정 오류~~~");
					k.printStackTrace();
				}
			}
		}
		return con;
	}
			
	public static void closeDB(Connection con,
			                   PreparedStatement ps,
			                   ResultSet rs){
//		트랜잭션의 마지막 단계로서 접속을 끊기 위한 method 이다. - DB의 부하를 줄이기 위함.
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}






















