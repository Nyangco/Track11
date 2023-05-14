package g_생성자;

public class J0125_1 {
	public static void main(String[] args) {
		J0125_1_dto sub = new J0125_1_dto();
		J0125_1_sub sub_ = new J0125_1_sub();

//		void와 null은 다르다 - null은 object의 초기변수. void는 말 그대로 없음.
		int kor = 0;
		
		kor = sub.getKor();
		System.out.println(kor);
		
		for(int k=1; k<=3; k++) {
			sub.setKor(k*100);
			kor = sub.getKor();
			System.out.println(kor);
		}
		
		String name = null;
		name = sub.getName();
		System.out.println(name);
		sub.setName("김개똥");
		name = sub.getName();
		System.out.println(name);
		sub.setName("홍길동");
		name = sub.getName();
		System.out.println(name);
		
		
	}
}

