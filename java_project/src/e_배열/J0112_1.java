package e_배열;

public class J0112_1 {

	public static void main(String[] args) {

		int[] b = new int[4];
		
		b[0]=10;
		b[1]=20;
		b[2]=30;
		
		//new int 뒤 대괄호의 숫자는 배열의 길이를 나타낸다!
		//b 라고 하는 변수가 int 타입의 배열이다 ! = 새로운 int 타입의 배열은 길이가 3이다.
		for( int c = 0; c<b.length; c++) System.out.println(b[c]);
		
		b[1]=200;
		
		for( int c = 0; c<b.length; c++) System.out.println(b[c]);
		
		String[] k = new String[7];
		
	}
}
