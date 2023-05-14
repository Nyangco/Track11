package z_study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCtemp {

	public static Connection getConnection() {
		Connection con = null;
		boolean goIng = false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			goIng=true;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(goIng==true) {
			try {
				String url = "url";
				String user = "user";
				String pw = "pw";
				con = DriverManager.getConnection(url, user, pw);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
		
	}
	
	public static void closeDB(Connection con, PreparedStatement ps, ResultSet rs) {
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
