package p_database;

import java.sql.Connection;
import java.util.Scanner;

public class J0214_main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0214_dao dao = new J0214_dao();
		
		System.out.print("ID? : ");
		String id = sc.next();
		String name = dao.getName(id);
		System.out.println(name);
	}
	
}

	
