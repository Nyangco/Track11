package g_생성자;

import java.util.Scanner;

public class J0127_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner("aa");
//		System.in 은 콘솔창에서 입력받은 값을 String type으로 작성하는 method이다.
		
		J0127_1_dto dto = new J0127_1_dto();
		String id = "";
		
		id = dto.getId();
		System.out.println(id);
		
		dto.setId("101");
		id = dto.getId();
		System.out.println(id);
		
		dto.setId("201");
		id = dto.getId();
		System.out.println(id);
		
		J0127_1_dto dto2 = new J0127_1_dto("301");
		id = dto2.getId();
		String name = dto2.getName();
		System.out.println(id);
		System.out.println(name);
		
		
		J0127_1_dto dto3 = new J0127_1_dto("301","이상화");
		name = dto3.getName();
		System.out.println(id);
		System.out.println(name);
		
		J0127_1_dto dto4 = new J0127_1_dto();
		dto4.setId("301");
		dto4.setName("이상화");
		dto4.setArea("대전");
		dto4.setAge(25);
		
		if(dto3 == dto4) System.out.println(true);
		//heap 영역은 서로 다르지만, 선언된 전역변수는 문자열이 같다면 같은 영역에 저장되기에 ==값이 true로 반환된다.
		
		
	}
}
