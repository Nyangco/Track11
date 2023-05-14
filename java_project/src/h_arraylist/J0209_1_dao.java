package h_arraylist;

import java.util.ArrayList;

public class J0209_1_dao {
	
	boolean checkAge(int k) {
		if(k>=0 && k<=120) return true;
		else return false;
	}
	
	int getPay(String str, int k) {
		int pay=1000000;
		
		switch (str) {
		case"남" : case"남자": case"남성":
			pay+=200000;
			break;
		case"여" : case"여자": case"여성":
			pay+=300000;
			break;
		default :
			pay=0;
		}
			
		if(k>=25 && pay!=0) pay+=100000;
		
		return pay;
	}
	
	void printArrList(ArrayList<J0209_1_dto> arr) {
		printIndex();
		for(int k=0; k<arr.size(); k++) {
			printDto(arr.get(k));
		}
		System.out.println("================================");
	}
	
	void printDto(J0209_1_dto dto) {
		System.out.print(dto.getName()+"\t");
		System.out.print(dto.getGender()+"\t");
		System.out.print(dto.getAge()+"\t");
		System.out.println(dto.getPay());
	}
	
	void printIndex() {
		System.out.println("================================");
		System.out.println("성명\t성별\t나이\t급여");
		System.out.println("================================");
	}

}
