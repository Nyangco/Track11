package i_String;

public class J0208_1 {

	public static void main(String[] args) {
		String str = "가나다라마바사";
		if(str.equals("가나다라마바사")) System.out.println("같다");
		else System.out.println("다르다");
		System.out.println("str의 길이 :"+str.length());
//		String class는 Object의 자식클래스 관계라서 Object의 method도 사용할 수 있다.
		
		System.out.println("str의 substring2 : "+str.substring(2));
		System.out.println("str의 substring2,4 : "+str.substring(2,4));
//		substring(a,b) : a 번째부터 b 전까지. b를 입력 안하면 a부터 끝까지
		
		int position = str.indexOf("다");
		System.out.println("다 의 위치 :"+position);
		System.out.println("다 부터 2개 글자 :"+str.substring(position,position+2));
		System.out.println("라 출력 :"+str.substring(str.indexOf("라"),str.indexOf("라")+1));
//		범위를 벗어나게끔 substring을 설정하면 exception 오류가 뜬다. -1도 마찬가지.
		
		if(str.length() > 3) {
			System.out.println(str.substring(0,3)+"...");
		}
		
//		length, substring, indexOf, equals 정도는 확실히 알 고 있을 것.
	}
}
