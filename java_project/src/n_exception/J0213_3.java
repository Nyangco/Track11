package n_exception;

public class J0213_3 {

	public static void main(String[] args) {
		String[] str = new String[2];
		
		str[0]="100";
		str[1]="200";
		
		int kor = 0, eng = 0, total = 0;
	
		try {
			kor = Integer.parseInt(str[0]);
			eng = Integer.parseInt(str[2]);
			total = kor+eng;
		}catch(Exception e) {
			System.out.println("오류");
			total = 0;
		}finally {
			
		}
		
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(total);
		System.out.println("종료");
		
	}
}
