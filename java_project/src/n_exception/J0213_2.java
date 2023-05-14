package n_exception;

public class J0213_2 {
//	ArrayIndexOutOfBoundsException
//	설정한 배열의 길이를 넘겨서 사용하고자 할 때 발생하는 오류.

	public static void main(String[] args) {
		String[] str = new String[2];
		
		str[0]="100";
		str[1]="2백";
		
		int kor = 0, eng = 0;
	
		try {
			kor = Integer.parseInt(str[0]);
			eng = Integer.parseInt(str[2]);
		}catch(NumberFormatException e) {
			System.out.println("숫자 포맷 오류");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 벗어남 오류");
		}
		
		finally {
			
		}
		
		System.out.println(kor);
		System.out.println(eng);
		System.out.println("종료");
		
		
	}
}
