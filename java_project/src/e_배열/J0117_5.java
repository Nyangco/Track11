package e_배열;

public class J0117_5 {

	public static void main(String[] args) {
		String[] aaa = {"홍길동","대전","25"};
		String[][] str = new String[2][3];
		String[][][] arr = new String[5][4][3];
		
		str[0][0] ="홍길동";
		str[0][1] ="대전";
		str[0][2] ="25";
		str[1][0] ="이상화";
		str[1][1] ="서울";
		str[1][2] ="30";
		
		int len = str.length;
		System.out.println("2차원 길이 : "+len);
		System.out.println(str[0].length);
		System.out.println(arr[3][1].length);
		
		for(int k=0; k<str.length; k++) {
			for(int i=0; i<str[0].length; i++) {
				System.out.print(str[k][i]+"\t");
			}
			System.out.print("\n");
			// \n -> new line -> 줄바꿈
			
		}
	}
}
