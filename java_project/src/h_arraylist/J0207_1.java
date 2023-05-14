package h_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class J0207_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0207_1_dto> arr = new ArrayList<>();
		
		
		J0207_1_dto dto1 = new J0207_1_dto("101","홍길동","대전",25);
		J0207_1_dto dto2 = new J0207_1_dto("201","이상화","서울",32);
		
		arr.add(dto1);
		arr.add(dto2);
		arr.add(new J0207_1_dto("301","김민식","부산",35));
		
		
		/*
		while(true) {
			System.out.println((arr.size()+1)+"번째 분의 ID를 입력해주세요 (0을 입력하면 종료됩니다.)");
			String id = sc.next();
			if(id.equals("0")) break;
			System.out.println((arr.size()+1)+"번째 분의 성함을 입력해주세요");
			String name = sc.next();
			System.out.println((arr.size()+1)+"번째 분의 지역을 입력해주세요");
			String area = sc.next();
			System.out.println((arr.size()+1)+"번째 분의 나이를 입력해주세요");
			int age = sc.nextInt();
			
			J0207_1_dto dto = new J0207_1_dto(id,name,area,age);
			arr.add(dto);
		}
		*/
		System.out.println("---------------------------");
		System.out.println("ID\t성함\t지역\t나이");
		System.out.println("---------------------------");
		for(int k=0; k<arr.size(); k++) {
			System.out.print(arr.get(k).getId()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getArea()+"\t");
			System.out.println(arr.get(k).getAge());
		}
		System.out.println("---------------------------");
		
		
	}
}
