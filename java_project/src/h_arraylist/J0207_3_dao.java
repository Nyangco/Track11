package h_arraylist;

import java.util.ArrayList;

public class J0207_3_dao {
	
	void printArr(ArrayList<J0207_3_dto> arr) {
		System.out.println("==============================");
		System.out.println("품종\t이름\t키\t무게");
		System.out.println("==============================");
		for(int k=0; k<arr.size(); k++) {
			System.out.print(arr.get(k).getKind()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getHeight()+"\t");
			System.out.println(arr.get(k).getWeight());
		}
		System.out.println("==============================");
	}

	String getKind(String str) {
		switch (str) {
		case"c": case"C": case"ㅊ":
			return "고양이";
		case"d": case"D": case"ㅇ":
			return "강아지";
		default :
			return "기타 품종";
		}
	}
}
