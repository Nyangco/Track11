package g_생성자;

import java.util.Scanner;

public class J0201_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0201_dao dao = new J0201_dao();
		
		String[] str = new String[3];
		for(int k=0; k<str.length; k++) {
			System.out.print("아무런 문자나 입력하라");
			str[k]=sc.next();		
		}
		
		for(int k=0; k<str.length; k++) {
			System.out.println(str[k]);
		}
	}
}
