package h_arraylist;

import java.util.ArrayList;

public class J0207_4_dao {
	
	void findName(ArrayList<J0207_4_dto> arr, String str) {
		indexPrint();
		for(int k=0; k<arr.size(); k++) {
			if(arr.get(k).getName().indexOf(str)!=-1) {
				printDto(arr.get(k));
			}else System.out.println("문자열에 해당하는 사원이 없습니다.");
			
		}
		System.out.println("---------------------------------------");
	}
	
	void indexPrint() {
		System.out.println("=======================================");
		System.out.println("ID\t성명\t나이\t부서\t직위");
		System.out.println("---------------------------------------");
	}
	
	void printDto(J0207_4_dto dto) {
		System.out.print(dto.getId()+"\t");
		System.out.print(dto.getName()+"\t");
		System.out.print(dto.getAge()+"\t");
		System.out.print(dto.getDepart()+"\t");
		System.out.println(dto.getRank());
	}
	
	void printArrList(ArrayList<J0207_4_dto> arr) {
		indexPrint();
		for(int k=0; k<arr.size(); k++) {
			printDto(arr.get(k));
		}
		System.out.println("---------------------------------------");
	}

	String getDepart(String str) {
		if(str.equals("10")) return "총무";
		else if(str.equals("20")) return "재무";
		else if(str.equals("30")) return "영업";
		else return "기타 부서";
	}
	
	String getRank(String str) {
		switch (str) {
		case "s" : case "S" : case "ㄴ" :
			return "사원";
		case "d" : case "D" : case "ㅇ" :
			return "대리";
		case "g" : case "G" : case "ㅎ" :
			return "과장";
		default :
			return "기타 직위";
		}
	}
}
