package g_생성자;

public class J0126_1 {

	public static void main(String[] args) {

		String name = "홍길동";
		System.out.println(name);

		J0126_1_dto dto = new J0126_1_dto();
		System.out.println(dto);
//		
//		System.out.println(dto.getName());
//		dto.setName("홍길동");
//		System.out.println(dto.getName());
//		class의 . method 자동완성 기능에 삼각형은 내가 만든 method표시
//		dto.setName("이상화");
//		System.out.println(dto.getName());


		J0126_1_dto dto_1 = new J0126_1_dto("김개똥");
		System.out.println(dto.getName());
		System.out.println(dto_1.getName());
		
	}
}
