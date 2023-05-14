package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0206_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("몇 명?");
//		int count = sc.nextInt();
		
		ArrayList<String> arr = new ArrayList<>();
		
		while(true) {
			System.out.print("성함 입력(0 입력시 종료): ");
			String temp = sc.next();
			if(temp.equals("0")) break;
			arr.add(temp);
		}
		
		for(int k=0; k<arr.size(); k++) {
			System.out.println(arr.get(k));
		}
		System.out.println(arr.size());
	}
}
