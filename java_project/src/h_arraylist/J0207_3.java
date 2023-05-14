package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0207_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0207_3_dao dao = new J0207_3_dao();
		
		ArrayList<J0207_3_dto> arr = new ArrayList<>();
		
		System.out.print("몇마리 입니까?");
		int count = sc.nextInt();
		
		for(int k=0; k<count; k++) {
			System.out.print("동물의 품종은 무엇입니까? (고양이:c 강아지:d)");
			String kind = sc.next();
			System.out.print("동물의 이름은 무엇입니까? ");
			String name = sc.next();
			System.out.print("동물의 키는 무엇입니까?");
			int height = sc.nextInt();
			System.out.print("동물의 무게는 얼마나 나갑니까?");
			int weight = sc.nextInt();
			
			kind = dao.getKind(kind);
			J0207_3_dto dto = new J0207_3_dto();
			dto.setKind(kind);
			dto.setName(name);
			dto.setHeight(height);
			dto.setWeight(weight);
			
			arr.add(dto);
		}
		
		dao.printArr(arr);
	}
}
